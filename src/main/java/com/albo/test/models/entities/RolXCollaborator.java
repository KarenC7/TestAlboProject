package com.albo.test.models.entities;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "rolxcollaborator")
public class RolXCollaborator {
	@EmbeddedId
    private RolXCollaboratorIdentity rolXCollaboratorIdentity;

	
	@OneToOne
    @JoinColumn(name="idRol", insertable=false, updatable=false)
    private Rol rol;
	
	@OneToOne
    @JoinColumn(name="idCollaborator", insertable=false, updatable=false)
    private Collaborator collaborator;
	

	public RolXCollaboratorIdentity obtenerRolXCollaboratorIdentity() {
		return rolXCollaboratorIdentity;
	}

	public void setRolXCollaboratorIdentity(RolXCollaboratorIdentity rolXCollaboratorIdentity) {
		this.rolXCollaboratorIdentity = rolXCollaboratorIdentity;
	}

	public Collaborator getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}

	public Rol obtenerRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	

	
	
	
	
	

}
