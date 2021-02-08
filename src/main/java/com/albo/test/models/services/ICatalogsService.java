package com.albo.test.models.services;

import java.util.List;

import com.albo.test.models.entities.CharXRelatedCharacterXComic;
import com.albo.test.models.entities.Collaborator;
import com.albo.test.models.entities.ComicCharacter;
import com.albo.test.models.entities.Rol;

public interface ICatalogsService {
	
	public Object findAll(String catalog);

	public Object save(String cat, Object entity);

	public Object findById(String cat, String id);

	public void delete(String catalogo, String id);

	public Object findByCriteria(String catalogo, Object filter);

	public List<Collaborator> findCollaboratorsByCriteria(Object entityFilter);

	public List<ComicCharacter> findCharactersByCriteria(Object entityFilter);

	public List<Rol> findRolByCriteria(Object entityFilter);

	public void deleteAll(String catalogo);

	public List<CharXRelatedCharacterXComic> findCharacterRelByCriteria(Object entityFilter);

	
}
