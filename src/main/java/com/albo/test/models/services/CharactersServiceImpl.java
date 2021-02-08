package com.albo.test.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albo.test.models.dao.IComicCharacterDao;
import com.albo.test.models.entities.CharacterXRolXCollaborator;
import com.albo.test.models.entities.ComicCharacter;
import com.albo.test.models.entities.CustomEntityCollaborator;


/**
 * Servicio para manejar las llamadas personalizadas 
*/

@Service
public class CharactersServiceImpl implements ICharactersService{
	
	@Autowired
	private IComicCharacterDao characterDao;
	
	
    /**
	 * @desc methodo para crear la salida personalizada
	 * @param Long - id del caracter a consultar
	 * @return Object de respuesta personalizada 
	*/
	@Transactional(readOnly = true)
	public Object findByName(String catalog) {
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
	public Object getCustomCharacter(Long id) {
		CustomEntityCollaborator col = new CustomEntityCollaborator();
		Optional<ComicCharacter> ch = characterDao.findById((long) id);
		List<String> editors = new ArrayList<String>();
		List<String> writers = new ArrayList<String>();
		List<String> colorists = new ArrayList<String>();
		for(CharacterXRolXCollaborator el: ch.get().getRelations()) {
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

}
