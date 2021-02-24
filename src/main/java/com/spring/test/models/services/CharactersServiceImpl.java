package com.spring.test.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.test.models.dao.IComicCharacterDao;
import com.spring.test.models.entities.CharXRelatedCharacterXComic;
import com.spring.test.models.entities.CharXRelatedCharacterXComicIdentity;
import com.spring.test.models.entities.CharacterXRolXCollaborator;
import com.spring.test.models.entities.ComicCharacter;
import com.spring.test.models.entities.CustomEntityCharacter;
import com.spring.test.models.entities.CustomEntityCollaborator;


/**
 * Servicio para manejar las llamadas personalizadas 
*/

@Service
public class CharactersServiceImpl implements ICharactersService{
	
	@Autowired
	private IComicCharacterDao characterDao;
	@Autowired
	private ICatalogsService catService;
	
	
    /**
	 * @desc methodo para crear la salida personalizada
	 * @param Long - id del caracter a consultar
	 * @return Object de respuesta personalizada 
	*/
	@Transactional(readOnly = true)
	public Object findByName(String catalog) {
		switch(catalog) {
			
			case "ironman":
				return getCustomCollaborator(new Long(1009368));
			case "capamerica":
				return getCustomCollaborator(new Long(1009220));
			default:
				return null;
		}
	}
	
	/**
	 * @desc methodo para crear la salida personalizada
	 * @param Long - id del caracter a consultar
	 * @return Object de respuesta personalizada 
	*/
	@Transactional(readOnly = true)
	public Object findCharacter(String catalog) {
		switch(catalog) {
			
			case "ironman":
				return getCustomCharacter(new Long(1009368));
			case "capamerica":
				return getCustomCharacter(new Long(1009220));
			default:
				return null;
		}
	}
	
	/**
	 * @desc methodo para crear la salida personalizada
	 * @param Long - id del caracter a consultar
	 * @return Object de respuesta personalizada 
	*/
	public Object getCustomCollaborator(Long id) {
		//Instanciamos nuestra entidad de respuesta personalizada
		CustomEntityCollaborator col = new CustomEntityCollaborator();
		//Buscamos por id
		Optional<ComicCharacter> ch = characterDao.findById((long) id);
		//Creamos tres listas para cada tipo de creador
		List<String> editors = new ArrayList<String>();
		List<String> writers = new ArrayList<String>();
		List<String> colorists = new ArrayList<String>();
		//Recorremos los colaboradores y agregamos a las listas segun corresponda
		for(CharacterXRolXCollaborator el: ch.get().getCollaborators()) {
			if(el.getRol().getName().equals("editor"))
				editors.add(el.getCollaborator().getName());
			if(el.getRol().getName().equals("writer"))
				writers.add(el.getCollaborator().getName());
			if(el.getRol().getName().equals("colorist"))
				colorists.add(el.getCollaborator().getName());
    	}
		col.setLast_sync(ch.get().getLastSync());
    	col.setEditors(editors);
    	col.setWriters(writers);
    	col.setColorists(colorists);
		return col;
	}
	
	/**
	 * @desc methodo para crear la salida personalizada de personajes y comics
	 * @param Long - id del personaje a consultar
	 * @return Object de respuesta personalizada 
	*/
	public Object getCustomCharacter(Long id) {
		//Instanciamos la Entidad personalizada
		CustomEntityCharacter col = new CustomEntityCharacter();
		//Buscamos el personaje por id
		Optional<ComicCharacter> ch = characterDao.findById((long) id);
		List<Object> obList= new ArrayList<Object>();
		//Recorremos
		for(CharXRelatedCharacterXComic el: ch.get().getComics()) {
			Object ob = el.getRelated().getName();
			//Agregamos el personaje a la lista si aun no existe en ella
			if(!obList.contains(ob)) {
				CharXRelatedCharacterXComicIdentity iden = new CharXRelatedCharacterXComicIdentity();
				iden.setIdRelated(el.getRelated().getIdRelated());
				
				//Buscamos los comics por personaje
				List<CharXRelatedCharacterXComic> comics = catService.findCharacterRelByCriteria(iden);
				obList.add(ob);
				List<String> comicsName = new ArrayList<String>();
				//Agregamos a la lista solo los nombres para que la respuesta sea como el formato planteado
				for(CharXRelatedCharacterXComic elem: comics) {
					comicsName.add(elem.getComic().getName());
				}
				obList.add(comicsName);
			}
			
    	}
		col.setCharacters(obList);
		col.setLast_sync(ch.get().getLastSync());

		return col;
	}

}
