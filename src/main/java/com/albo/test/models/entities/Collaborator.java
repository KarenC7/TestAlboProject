package com.albo.test.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collaborators")
public class Collaborator {
	@Id
	@Column(name = "ID_COLLABORATOR", nullable = false)
	private Long idCollaborator;
	@Column(name = "NAME")
	private String name;
	
	
	public Long getIdCollaborator() {
		return idCollaborator;
	}
	public void setIdCollaborator(Long idCollaborator) {
		this.idCollaborator = idCollaborator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Collaborator [idCollaborator=" + idCollaborator + ", name=" + name + "]";
	}
	
	
	
	


}
