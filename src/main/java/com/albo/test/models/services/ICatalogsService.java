package com.albo.test.models.services;

public interface ICatalogsService {
	
	public Object findAll(String catalog);

	public Object save(String cat, Object entity);

	public Object findById(String cat, String id);

	public void delete(String catalogo, String id);

	public Object findByCriteria(String catalogo, Object filter);
	
}
