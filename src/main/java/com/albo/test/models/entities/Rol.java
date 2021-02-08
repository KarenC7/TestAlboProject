package com.albo.test.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
	@Id
	@Column(name = "ID_ROL", nullable = false)
	private Long idRol;
	@Column(name = "NAME")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="rol")
    private List<RolXCollaborator> collaborators;
	
	
	
	public List<RolXCollaborator> getCollaborators() {
		return collaborators;
	}
	public void setCollaborators(List<RolXCollaborator> collaborators) {
		this.collaborators = collaborators;
	}
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", name=" + name + "]";
	}
	
	
	
	
}
	
	