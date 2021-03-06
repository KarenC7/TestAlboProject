package com.spring.test.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.models.services.ICatalogsService;

//Permite que se llamen las APIS desde el dominio de prueba
@CrossOrigin(origins = {"http://test.albo.mx/"})

@RestController
@RequestMapping("/_api")
public class CatalogsController {
	
	@Autowired
	private ICatalogsService catService;
	
	
	/**
	 * @desc ruta general de servicios para obtener todos los registros de las entidades
	 * @param String catalog - el catalogo a ser consultado
	 * @return ResponseEntity<?>(JSON del registro de la entidad, estatus de respuesta) 
	*/
	@GetMapping("/catalog/{catalog}")
	public ResponseEntity<?> listCat(@PathVariable String catalog){
		Object catEntity = null;
		Map<String, Object> response = new HashMap<>();
		try {
			
			//Llamada al servicio
			catEntity = catService.findAll(catalog);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(IllegalArgumentException mapExcepcion) {
			response.put("mensaje", "Error al mapear datos.");
			response.put("error", mapExcepcion.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if(catEntity == null) {
			response.put("mensaje", "No existen elementos.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(catEntity, HttpStatus.OK);

	
	}
	
	/**
	 * @desc ruta general de servicios para obtener un registro de entidad por id
	 * @param String catalog, String id - el catalogo y el id del registro a ser consultado
	 * @return ResponseEntity<?>(JSON del registro de la entidad, estatus de respuesta) 
	*/
	@GetMapping("/catalog/{catalog}/{id}")
	public ResponseEntity<?> show(@PathVariable String catalog, @PathVariable String id) {

		Object catalogosEntity = null;
		Map<String, Object> response = new HashMap<>();

		try {
			//Llamada al servicio
			catalogosEntity = catService.findById(catalog, id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(catalogosEntity == null) {
			response.put("mensaje", "No existe el elemento con el ID: ".concat(id));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(catalogosEntity, HttpStatus.OK);
	}
	/**
	 * @desc ruta general de servicios para guardar registros de entidad
	 * @param Object entity, String catalogo - JSON de entidad y entidad donde se guardara
	 * @return ResponseEntity<?>(JSON del registro que se guardo, estatus de respuesta) 
	*/
	@PostMapping("/catalog/{catalogo}")
	public ResponseEntity<?> create(@RequestBody Object entity, @PathVariable String catalogo) {

		Object catalogosEntity = null;
		Map<String, Object> response = new HashMap<>();

		try {
			//Llamada al servicio
			catalogosEntity = catService.save(catalogo, entity);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar/actualizar en la base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Object>(catalogosEntity, HttpStatus.OK);
		
		
	}
	
	/**
	 * @desc ruta general de servicios para filtrar registros de entidad
	 * @param Object filter, String catalogo - JSON de filtro y catalogo a ser consultado
	 * @return ResponseEntity<?>(JSON de los registros que coinciden con el filtro, estatus de respuesta) 
	*/
	@PostMapping("/catalog/filter/{catalogo}")
	public ResponseEntity<?> filtrar(@RequestBody Object filter, @PathVariable String catalogo){

		Object catalogosEntity = null;
		Map<String, Object> response = new HashMap<>();

		try {
			//Llamada al servicio
			catalogosEntity = catService.findByCriteria(catalogo, filter);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(IllegalArgumentException mapExcepcion) {
			response.put("mensaje", "Error al mapear datos.");
			response.put("error", mapExcepcion.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if(catalogosEntity == null) {
			response.put("mensaje", "No existen elementos.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(catalogosEntity, HttpStatus.OK);

	}
	
}
