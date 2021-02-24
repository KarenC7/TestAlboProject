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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.models.services.ICharactersService;

//Permite que se llamen las APIS desde el dominio de prueba
@CrossOrigin(origins = {""})

//Urls solicitadas para mostrar por personaje

@RestController
@RequestMapping("/marvel")
public class ShowController {
	
	@Autowired
	private ICharactersService catService;
	
	/**
	 * @desc ruta generalpara mostrar colaboradores por rol
	 * @param String catalog - el catalogo personalizado a ser consultado
	 * @return ResponseEntity<?>(JSON del registro de la entidad, estatus de respuesta) 
	*/
	@GetMapping("/collaborators/{character}")
	public ResponseEntity<?> listCollaborators(@PathVariable String character){
		Object catEntity = null;
		Map<String, Object> response = new HashMap<>();
		try {
			
			//Llamada al servicio
			catEntity = catService.findByName(character);
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
	 * @desc ruta general para mostrar comics por personaje relacionado
	 * @param String catalog - el catalogo personalizado a ser consultado
	 * @return ResponseEntity<?>(JSON del registro de la entidad, estatus de respuesta) 
	*/
	@GetMapping("/characters/{character}")
	public ResponseEntity<?> listCharacters(@PathVariable String character){
		Object catEntity = null;
		Map<String, Object> response = new HashMap<>();
		try {
			
			//Llamada al servicio
			catEntity = catService.findCharacter(character);
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
	
	
}