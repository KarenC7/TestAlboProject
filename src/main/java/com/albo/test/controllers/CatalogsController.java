package com.albo.test.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albo.test.models.services.ICatalogsService;

@RestController
@RequestMapping("/_api")
public class CatalogsController {
	
	@Autowired
	private ICatalogsService catService;
	
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
	
}
