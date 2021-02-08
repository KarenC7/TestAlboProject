package com.albo.test.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albo.test.models.entities.CharXRelatedCharacterXComicIdentity;
import com.albo.test.models.entities.CharacterXRolXCollaboratorIdentity;
import com.albo.test.models.entities.Collaborator;
import com.albo.test.models.entities.Comic;
import com.albo.test.models.entities.ComicCharacter;
import com.albo.test.models.entities.RelatedCharacter;
import com.albo.test.models.entities.Rol;
import com.albo.test.models.services.ICatalogsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//Permite que se llamen las APIS desde el dominio de prueba
@CrossOrigin(origins = {"http://test.albo.mx/"})

@RestController
@RequestMapping("/_api")
public class SyncController {
	
	@Autowired
	private ICatalogsService catService;
	
	/**
	 * @desc ruta general para sincronizar los colaboradores de comics de cada personaje y comics
	 * @param NA
	 * @return ResponseEntity<?>(JSON del registro de la entidad Collaborators, estatus de respuesta) 
	*/
	@GetMapping("/sync")
	public ResponseEntity<?> sync() throws IOException {
		//Declaramos el response que se retornara
		Map<String, Object> response = new HashMap<>();
		
		List<Object> list = new ArrayList<Object>();
		
		//Vaciamos la tabla de relaciones de colaboradores por rol
		catService.deleteAll("characterxrol");
		
		//Vaciamos la tabla de relaciones de caracteres  por comic y personajes relacionados
		catService.deleteAll("characterxrelated");
		
		//Obtenemos los personajes dados de alta (Iron man y Capitan America
		ComicCharacter comic = new ComicCharacter();
		List<ComicCharacter> cha = catService.findCharactersByCriteria(comic);
		
		//Recorremos cada personaje
		for(ComicCharacter co: cha) {
		
		//Asignamos a la URL nuestro parametro de id del personaje
		String url = "https://gateway.marvel.com:443/v1/public/characters/"+co.getIdCharacter()+"/comics?ts=1&apikey=1760c45ca4cabd6e9d4010e56df45bbd&hash=1addd69871606a85cb522d8bd34b6933";
		URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Default es GET
        con.setRequestMethod("GET");

        //Obtenemos la respuesta de la conexion
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        
        //Declaramos el buffer con la entrada 
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        //Declaramos una respuesta que se llena con el recorrido del buffer
        StringBuffer resp = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
        	resp.append(inputLine);
        }
      
        in.close();   //Cerramos
        
        //Se declara un objeto y un nodo para poder Mappear y convertir a las entidades correspondientes
        ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj;

		try {
			
		  //Se convierte a JSON la respuesta
		  actualObj = mapper.readTree(resp.toString());
			
		  int count = 0;
		  //Validamos que no sea null la estructura Base del JSON
		  if(actualObj!=null && actualObj.get("data")!=null && actualObj.get("data").get("results")!=null) {
			  //Si se obtiene informacion en el apartado results, se recorre
			  while(count<actualObj.get("data").get("results").size()) {
				  
				  	if(!chargeCollaboratorsRol(actualObj,count,co)) 
				  		response.put("Error", "No se pudo agregar las relaciones de colaborador");
				  	
					if(!chargeComicsRelatedCharacters(actualObj,count,co))
						response.put("Error", "No se pudo agregar las relaciones de comics");
				  	
				
					count++;
			  	}
		  	}
			  
			
		} catch (JsonProcessingException e) {
			response.put("mensaje", "Error con formato Json.");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		//Obtenemos la fecha actual del servidor donde se corre la aplicacion y se actualiza el personaje
		System.out.println(co.getIdCharacter());
		System.out.println(co.getName());
		System.out.println(co.getLastSync());
		//System.out.println(co.getRoles());
		
		try {
			Date date = new Date();
			co.setLastSync(date);
			catService.save("characters", co);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
    	
		
     
	} // Termina for de recorrido de personajes
		
		list.add(catService.findAll("collaborators"));
		return new ResponseEntity<Object>(list, HttpStatus.OK);
  }
	
	
	/**
	 * @desc ruta  para sincronizar los  comics de cada personaje
	
	*/
	public Boolean chargeComicsRelatedCharacters(JsonNode actualObj,int count,ComicCharacter co) {
		ObjectMapper mapper = new ObjectMapper();
		//Validamos que no sea null la porcion de JSON de donde tomamos los comics
		if(actualObj.get("data").get("results").get(count).get("id")!=null
		&& actualObj.get("data").get("results").get(count).get("title")!=null) {
			Object ent = null; 
			try {
				Comic com = new Comic();	
				
				com.setIdComic(Long.valueOf(actualObj.get("data").get("results").get(count).get("id").toString().replaceAll("\"", "")));
				com.setName(actualObj.get("data").get("results").get(count).get("title").toString().replaceAll("\"", ""));
				ent = catService.save("comic", com);
				Comic idComic = mapper.convertValue(ent, Comic.class);
			
				//Validamos que no sea null la porcion de JSON de donde tomamos personajes relacionados e Items
				if(actualObj.get("data").get("results").get(count).get("characters")!=null
					&& actualObj.get("data").get("results").get(count).get("characters").get("items")!=null) {
					int items = 0;
				
					while(items<actualObj.get("data").get("results").get(count).get("characters").get("items").size()) {
					
						
						//Del campo resourceURI obtenemos la ultima parte de la cadena, la cual corresponde al Id del colaborador
						String[] uri = actualObj.get("data").get("results").get(count).get("characters").get("items").get(items).get("resourceURI").toString().split("/");
						
						ent = null; //catService.findById("collaborators", uri[uri.length-1]);
						//Guardamos u actualizamos el colaborador 
						RelatedCharacter newCharacter= new RelatedCharacter();
						Long myId = new Long(uri[uri.length-1].toString().replaceAll("\"", ""));
						if(myId!=co.getIdCharacter()) {
							newCharacter.setIdRelated(myId);
							newCharacter.setName(actualObj.get("data").get("results").get(count).get("characters").get("items").get(items).get("name").toString().replaceAll("\"", ""));
							ent = catService.save("relatedcharacter", newCharacter);
									
							//Obtenemos la respuesta despues de guardar para obtener los ids
							RelatedCharacter col = mapper.convertValue(ent, RelatedCharacter.class);
							//Guardamos ahora la relacion de colaborador con el rol			
							CharXRelatedCharacterXComicIdentity rel = new CharXRelatedCharacterXComicIdentity();
							rel.setIdCharacter(co.getIdCharacter());
							rel.setIdRelated(col.getIdRelated());
							rel.setIdComic(idComic.getIdComic());
							catService.save("characterxrelated", rel);
						}		
					
							
						items++;
					}
				}
			}catch(Exception e) {
				e.getMessage();
				return false;
			}
		  }
		return true;

	}
	/**
	 * @desc ruta  para sincronizar los colaboradores de comics de cada personaje
	
	*/
	public Boolean chargeCollaboratorsRol(JsonNode actualObj,int count,ComicCharacter co) {
		ObjectMapper mapper = new ObjectMapper();
		  //Validamos que no sea null la porcion de JSON de donde tomamos creadores e Items
		if(actualObj.get("data").get("results").get(count).get("creators")!=null
			&& actualObj.get("data").get("results").get(count).get("creators").get("items")!=null) {
				int items = 0;
				
				while(items<actualObj.get("data").get("results").get(count).get("creators").get("items").size()) {
					Rol myRol = new Rol();
					myRol.setName(actualObj.get("data").get("results").get(count).get("creators").get("items").get(items).get("role").toString().replaceAll("\"","").replaceAll("'",""));
					List<Rol> newRol = catService.findRolByCriteria(myRol);
					//Si el catalogo se encuentra dado de alta como "editor", "writer" o "colorist", entonces continua
					if(!newRol.isEmpty()) {
						
						//Del campo resourceURI obtenemos la ultima parte de la cadena, la cual corresponde al Id del colaborador
						String[] uri = actualObj.get("data").get("results").get(count).get("creators").get("items").get(items).get("resourceURI").toString().split("/");
						
						Object ent = null; //catService.findById("collaborators", uri[uri.length-1]);
						//Guardamos u actualizamos el colaborador 
						try {
							Collaborator newCollaborator = new Collaborator();
							newCollaborator.setIdCollaborator(new Long(uri[uri.length-1].toString().replaceAll("\"", "")));
							newCollaborator.setName(actualObj.get("data").get("results").get(count).get("creators").get("items").get(items).get("name").toString().replaceAll("\"", ""));
							ent = catService.save("collaborators", newCollaborator);
							
							//Obtenemos la respuesta despues de guardar para obtener Id
							Collaborator col = mapper.convertValue(ent, Collaborator.class);
							//Guardamos ahora la relacion de colaborador con el rol			
							CharacterXRolXCollaboratorIdentity rel = new CharacterXRolXCollaboratorIdentity();
							rel.setIdCollaborator(col.getIdCollaborator());
							rel.setIdRol(newRol.get(0).getIdRol());
							rel.setIdCharacter(co.getIdCharacter());
							catService.save("characterxrol", rel);
							
						}catch(Exception e) {
							e.getMessage();
							return false;
						}
						
								
					}
							
				items++;
				}
			}
		return true;
	}
	
}
