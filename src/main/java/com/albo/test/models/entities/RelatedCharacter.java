package com.albo.test.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "related_character")
public class RelatedCharacter {
	@Id
	@Column(name = "ID_RELATED", nullable = false)
	private Long idRelated;
	@Column(name = "NAME")
	private String name;
	
	
	
	public Long getIdRelated() {
		return idRelated;
	}
	public void setIdRelated(Long idRelated) {
		this.idRelated = idRelated;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
