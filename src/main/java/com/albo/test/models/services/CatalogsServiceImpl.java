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

import com.albo.test.models.dao.ICharXRelatedCharacterXComicDao;
import com.albo.test.models.dao.ICharacterXRolXCollaboratorDao;
import com.albo.test.models.dao.ICollaboratorDao;
import com.albo.test.models.dao.IComicCharacterDao;
import com.albo.test.models.dao.IComicDao;
import com.albo.test.models.dao.IRelatedCharacterDao;
import com.albo.test.models.dao.IRolDao;
import com.albo.test.models.entities.Collaborator;
import com.albo.test.models.entities.Comic;
import com.albo.test.models.entities.ComicCharacter;
import com.albo.test.models.entities.RelatedCharacter;
import com.albo.test.models.entities.Rol;
import com.albo.test.models.entities.CharXRelatedCharacterXComic;
import com.albo.test.models.entities.CharXRelatedCharacterXComicIdentity;
import com.albo.test.models.entities.CharacterXRolXCollaborator;
import com.albo.test.models.entities.CharacterXRolXCollaboratorIdentity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CatalogsServiceImpl implements ICatalogsService {

	@Autowired
	private ICollaboratorDao collaboratorDao;
	@Autowired
	private IComicCharacterDao characterDao;
	@Autowired
	private ICharacterXRolXCollaboratorDao characterRolDao;
	@Autowired
	private IComicDao comicDao;
	@Autowired
	private IRelatedCharacterDao relatedDao;
	@Autowired
	private ICharXRelatedCharacterXComicDao charRelDao;

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
			case "comic":
				return comicDao.findAll();
			case "relatedCharacter":
				return relatedDao.findAll();
			case "characterxrelated":
				return charRelDao.findAll();
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
	       case "roles":                
	          	return rolDao.findById(new Long(id));
	       case "comic":                
	          	return comicDao.findById(new Long(id));
	       case "relatedCharacter":                
	          	return relatedDao.findById(new Long(id));
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
	        	case "roles":                
	        		Rol ro = mapper.convertValue(entity, Rol.class);
	            	return rolDao.save(ro);
	        	case "characterxrol":                
	        		CharacterXRolXCollaboratorIdentity ide = mapper.convertValue(entity, CharacterXRolXCollaboratorIdentity.class);
	        		CharacterXRolXCollaborator chcol = new CharacterXRolXCollaborator();
	            	chcol.setCharacterXRolIdentity(ide);
	        		return characterRolDao.save(chcol);
	        	case "comic":                
	        		Comic co = mapper.convertValue(entity, Comic.class);
	            	return comicDao.save(co);
	        	case "relatedcharacter":                
	        		RelatedCharacter relchar = mapper.convertValue(entity, RelatedCharacter.class);
	            	return relatedDao.save(relchar);
	        	case "characterxrelated":                
	        		CharXRelatedCharacterXComicIdentity rel = mapper.convertValue(entity, CharXRelatedCharacterXComicIdentity.class);
	        		CharXRelatedCharacterXComic chrel = new CharXRelatedCharacterXComic();
	            	chrel.setCharacterXRelatedIdentity(rel);
	        		return charRelDao.save(chrel);
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
				case "characters":  
					characterDao.deleteById(new Long(id));  
					 break;
				case "roles":  
					rolDao.deleteById(new Long(id));  
	                break;
				case "comic":  
					comicDao.deleteById(new Long(id));
					break;
				case "relatedcharacter":  
					relatedDao.deleteById(new Long(id));
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
				case "characters":  
					characterDao.deleteAll();  
					 break;
				case "roles":  
					rolDao.deleteAll();  
	                break;
				case "characterxrol":  
					characterRolDao.deleteAll();  
	                break;
				case "comic":  
					comicDao.deleteAll();
					break;
				case "relatedcharacter":  
					relatedDao.deleteAll();
	                break;
				case "characterxrelated":  
					charRelDao.deleteAll();  
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
	            case "roles":  
	            	return findRolByCriteria(filter);
				case "comic":  
					return findComicByCriteria(filter);
				case "relatedcharacter":  
					return findRelatedCharacterByCriteria(filter);
				case "characterxrelated":  
					return findCharacterRelByCriteria(filter);
				
	            default:
	                return null;
	        }
		}

		
		/**
	   	 *Aqui comienzan los metodos de filtrado personalizado por tabla
	   	 * 
	   	*/
		
		
		@Override
		 public List<Collaborator> findCollaboratorsByCriteria(Object entityFilter){
			 Collaborator filter = mapper.convertValue(entityFilter, Collaborator.class);
				
				return collaboratorDao.findAll(new  Specification<Collaborator>() {
				
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
		
		
		 public List<Comic> findComicByCriteria(Object entityFilter){
			Comic filter = mapper.convertValue(entityFilter, Comic.class);
				
				return comicDao.findAll(new  Specification<Comic>() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public Predicate toPredicate(Root<Comic> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
						List<Predicate> predicates = new ArrayList<>();
						
						if(filter.getIdComic()!= null) {
							predicates.add(cb.and(cb.equal(root.get("idComic"), filter.getIdComic())));
		                }
						if(filter.getName() != null) {
							predicates.add(cb.and(cb.like(cb.upper(root.get("name")), "%" + filter.getName().toUpperCase() + "%")));
						}
						return cb.and(predicates.toArray(new Predicate[predicates.size()]));
					}

			
					
				});
		    }
		 
		 public List<RelatedCharacter> findRelatedCharacterByCriteria(Object entityFilter){
			 RelatedCharacter filter = mapper.convertValue(entityFilter, RelatedCharacter.class);
					
					return relatedDao.findAll(new  Specification<RelatedCharacter>() {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						@Override
						public Predicate toPredicate(Root<RelatedCharacter> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
							List<Predicate> predicates = new ArrayList<>();
							
							if(filter.getIdRelated()!= null) {
								predicates.add(cb.and(cb.equal(root.get("idRelated"), filter.getIdRelated())));
			                }
							if(filter.getName() != null) {
								predicates.add(cb.and(cb.like(cb.upper(root.get("name")), "%" + filter.getName().toUpperCase() + "%")));
							}
							return cb.and(predicates.toArray(new Predicate[predicates.size()]));
						}

				
						
					});
			    }

		
		public List<CharXRelatedCharacterXComic> findCharacterRelByCriteria(Object entityFilter){
			CharXRelatedCharacterXComicIdentity filter = mapper.convertValue(entityFilter, CharXRelatedCharacterXComicIdentity.class);
				
				return charRelDao.findAll(new  Specification<CharXRelatedCharacterXComic>() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public Predicate toPredicate(Root<CharXRelatedCharacterXComic> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
						List<Predicate> predicates = new ArrayList<>();
						
						if(filter.getIdRelated() != null) {
							predicates.add(cb.and(cb.equal(root.get("related").get("idRelated"), filter.getIdRelated())));
		                }
						
						return cb.and(predicates.toArray(new Predicate[predicates.size()]));
					}

					
				});
		    }
	
}
