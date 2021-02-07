package com.albo.test.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albo.test.models.dao.ICollaboratorDao;
import com.albo.test.models.entities.Collaborator;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CatalogsServiceImpl implements ICatalogsService {

	@Autowired
	private ICollaboratorDao collaboratorDao;
	
	@Override
	@Transactional(readOnly = true)
	public Object findAll(String catalog) {
		switch(catalog) {
			case "collaborators":
				return collaboratorDao.findAll();
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
	            	//return findCalendarioByCriteria(filter);
	           
	            default:
	                return null;
	        }
		}
	
}
