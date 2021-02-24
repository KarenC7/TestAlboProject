package com.spring.test.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Permite que se llamen las APIS desde el dominio de prueba
@CrossOrigin(origins = {""})

@RestController
@RequestMapping("/")
public class MainController {
	
	@RequestMapping(method=RequestMethod.GET)
	public Object index() throws IOException {
		List<Object> list = new ArrayList<Object>();
		List<String> service = new ArrayList<String>();
		service.add("All request: https://www.postman.com/KarenCast7");
	
		service.add("----------------------------");
        service.add("POST");
        service.add("Save record");
        service.add("{host}/_api/catalog/{catalog}");
        service.add("Posible catalogs: collaborators, characters, roles, comic, relatedcharacter, characterxrol, characterxrelated");
	
		service.add("----------------------------");
        service.add("GET");
        service.add("Get all from all catalogs");
        service.add("{host}/_api/catalog/{catalog}");
        service.add("Posible catalogs: collaborators, characters, roles, comic, relatedcharacter, characterxrol, characterxrelated");
		
		service.add("----------------------------");
        service.add("GET");
        service.add("Get by Id");
        service.add("{host}/_api/catalog/{catalog}/{id}");
        service.add("Posible catalogs: collaborators, characters, roles, comic, relatedcharacter");
		
		service.add("----------------------------");
        service.add("POST");
        service.add("Filter data");
        service.add("{host}/_api/catalog/filter/{catalog}");
        service.add("Posible catalogs: collaborators, characters, roles, comic, relatedcharacter");
		list.add(service);
        
        return list;
	}

}
