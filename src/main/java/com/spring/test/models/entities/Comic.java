package com.spring.test.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comic")
public class Comic{
	@Id
	@Column(name = "ID_COMIC", nullable = false)
	private Long idComic;
	@Column(name = "NAME")
	private String name;
	
	
	public Long getIdComic() {
		return idComic;
	}
	public void setIdComic(Long idComic) {
		this.idComic = idComic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}