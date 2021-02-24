package com.spring.test.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
	@Id
	@Column(name = "ID_ROL", nullable = false)
	private Long idRol;
	@Column(name = "NAME")
	private String name;
	
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
	
	