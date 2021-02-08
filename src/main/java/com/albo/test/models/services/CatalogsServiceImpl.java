package com.albo.test.models.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albo.test.models.dao.ICharacterXRolDao;
import com.albo.test.models.dao.ICollaboratorDao;
import com.albo.test.models.dao.IComicCharacterDao;
import com.albo.test.models.dao.IRolDao;
import com.albo.test.models.dao.IRolXCollaboratorDao;
import com.albo.test.models.entities.Collaborator;
import com.albo.test.models.entities.ComicCharacter;
import com.albo.test.models.entities.Rol;
import com.albo.test.models.entities.RolXCollaborator;
import com.albo.test.models.entities.RolXCollaboratorIdentity;
import com.albo.test.models.entities.CharacterXRol;
import com.albo.test.models.entities.CharacterXRolIdentity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CatalogsServiceImpl implements ICatalogsService {

	@Autowired
	private ICollaboratorDao collaboratorDao;
	@Autowired
	private IComicCharacterDao characterDao;
	@Autowired
	private ICharacterXRolDao characterRolDao;
	@Autowired
	private IRolXCollaboratorDao rolCollaboratorDao;
	@Autowired
	private IRolDao rolDao;
	 //Se declara una variable mapper global que se utilizara para mappear el objeto a la entidad
    private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	@Transactional(readOnly = true)
	public Object findAll(String catalog) {
		switch(catalog) {
			case "collaborators":
				return collaboratorDao.findAll();
			case "characters":
				return characterDao.findAll();
			case "roles":
				return rolDao.findAll();
			case "characterxrol":
				return characterRolDao.findAll();
			case "rolxcollaborator":
				return rolCollaboratorDao.findAll();
			default:
				return null;
		}
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Object findById(String cat, String id) {
	   switch (cat) {
	       case "collaborators":                
	          	return collaboratorDao.findById(new Long(id));
	       case "characters":                
	          	return characterDao.findById(new Long(id));
	       default:
	            return null;
	    }
	 }

	    /**
	   	 * @desc metodo que permite guardar registros en la Tabla a la que hace referencia una entidad segun la variable catalogo
	   	 * @param catalogo, entity - String con el nombre del catalogo (entidad) a consultar y Objeto JSON que se va a guardar
	   	 * en la entidad, se mappea segun al catalogo que corresponda
	   	 * @return Object - JSON del registro guardado
	   	*/
	    @Override
	    @Transactional
	    public Object save(String cat, Object entity) {
	        ObjectMapper mapper = new ObjectMapper();
	        switch (cat) {
	        	case "collaborators":                
	        		Collaborator col = mapper.convertValue(entity, Collaborator.class);
	            	return collaboratorDao.save(col);
	        	case "characters":                
	        		ComicCharacter ch = mapper.convertValue(entity, ComicCharacter.class);
	            	return characterDao.save(ch);
	        	case "rol":                
	        		Rol ro = mapper.convertValue(entity, Rol.class);
	            	return rolDao.save(ro);
	        	case "characterxrol":                
	        		CharacterXRolIdentity ide = mapper.convertValue(entity, CharacterXRolIdentity.class);
	        		CharacterXRol chcol = new CharacterXRol();
	            	chcol.setCharacterXRolIdentity(ide);
	        		return characterRolDao.save(chcol);
	        	case "rolxcollaborator":                
	        		RolXCollaboratorIdentity rocId = mapper.convertValue(entity, RolXCollaboratorIdentity.class);
	        		RolXCollaborator roc = new RolXCollaborator();
	            	roc.setRolXCollaboratorIdentity(rocId);
	        		return rolCollaboratorDao.save(roc);
	        	
	            default:
	                return null;
	        }
	    }

	    
	    /**
	   	 * @desc metodo que permite eliminar registros en la Tabla a la que hace referencia una entidad (No se usa en la vista,
	   	 *  solo es para control directo en POSTMAN)
	   	 * @param catalogo, id - String con el nombre del catalogo (entidad) a consultar y id del registro a eliminar
	   	*/
	 
		@Override
	    @Transactional
	    public void delete(String catalogo, String id) {
	        switch (catalogo) {
				case "collaborators":  
					collaboratorDao.deleteById(new Long(id));              
	                break;
	            default:
	                break;
	        }
	    }
		

		@Override
	    @Transactional
	    public void deleteAll(String catalogo) {
	        switch (catalogo) {
				case "collaborators":  
					collaboratorDao.deleteAll();              
	                break;
				case "characterxrol":  
					characterRolDao.deleteAll();  
				case "rolxcollaborator":  
					rolCollaboratorDao.deleteAll();  
	                break;
	            default:
	                break;
	        }
	    }

	    /**
	   	 * @desc metodo que permite filtrar registros en la Tabla a la que hace referencia una entidad dado el catalogo
	   	 * @param catalogo, filter - String con el nombre del catalogo (entidad) a consultar y 
	   	 * Objeto JSON que se va a  mappear segun al catalogo que corresponda para comparar con los registros
	   	 * @return Object - JSON de registros que cumplan el filtrado
	   	*/
	 
		@Override
	    public Object findByCriteria(String catalogo, Object filter) {
	        switch (catalogo) {
	            case "collaborators":            
	            	return findCollaboratorsByCriteria(filter);
	            case "characters":            
	            	return findCharactersByCriteria(filter);
	           
	            default:
	                return null;
	        }
		}

		@Override
		 public List<Collaborator> findCollaboratorsByCriteria(Object entityFilter){
			 Collaborator filter = mapper.convertValue(entityFilter, Collaborator.class);
				
				return collaboratorDao.findAll(new  Specification<Collaborator>() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public Predicate toPredicate(Root<Collaborator> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
						List<Predicate> predicates = new ArrayList<>();
						
						if(filter.getIdCollaborator()!= null) {
							predicates.add(cb.and(cb.equal(root.get("idCollaborator"), filter.getIdCollaborator())));
		                }
						
						return cb.and(predicates.toArray(new Predicate[predicates.size()]));
					}
					
				});
		    }
	
		@Override
		 public List<ComicCharacter> findCharactersByCriteria(Object entityFilter){
			 ComicCharacter filter = mapper.convertValue(entityFilter, ComicCharacter.class);
				
				return characterDao.findAll(new  Specification<ComicCharacter>() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public Predicate toPredicate(Root<ComicCharacter> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
						List<Predicate> predicates = new ArrayList<>();
						
						if(filter.getIdCharacter()!= null) {
							predicates.add(cb.and(cb.equal(root.get("idCharacter"), filter.getIdCharacter())));
		                }
						
						return cb.and(predicates.toArray(new Predicate[predicates.size()]));
					}

			
					
				});
		    }
		
		@Override
		 public List<Rol> findRolByCriteria(Object entityFilter){
			Rol filter = mapper.convertValue(entityFilter, Rol.class);
				
				return rolDao.findAll(new  Specification<Rol>() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public Predicate toPredicate(Root<Rol> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
						List<Predicate> predicates = new ArrayList<>();
						
						if(filter.getIdRol()!= null) {
							predicates.add(cb.and(cb.equal(root.get("idRol"), filter.getIdRol())));
		                }
						if(filter.getName() != null) {
							predicates.add(cb.and(cb.like(cb.upper(root.get("name")), "%" + filter.getName().toUpperCase() + "%")));
						}
						return cb.and(predicates.toArray(new Predicate[predicates.size()]));
					}

			
					
				});
		    }
		
	
}
