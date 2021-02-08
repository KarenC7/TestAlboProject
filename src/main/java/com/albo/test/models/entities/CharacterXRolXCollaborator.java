package com.albo.test.models.entities;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "characterxrolxcollaborator")
public class CharacterXRolXCollaborator {
	@EmbeddedId
    private CharacterXRolXCollaboratorIdentity characterXRolIdentity;

	@OneToOne
    @JoinColumn(name="idCharacter", insertable=false, updatable=false)
    private ComicCharacter character;
	
	@OneToOne
    @JoinColumn(name="idRol", insertable=false, updatable=false)
    private Rol rol;
	
	@OneToOne
    @JoinColumn(name="idCollaborator", insertable=false, updatable=false)
    private Collaborator collaborator;
	
	
	
	public Collaborator getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}

	public ComicCharacter obtenerCharacter() {
		return character;
	}

	public void setCharacter(ComicCharacter character) {
		this.character = character;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public CharacterXRolXCollaboratorIdentity obtenerCharacterXRolIdentity() {
		return characterXRolIdentity;
	}

	public void setCharacterXRolIdentity(CharacterXRolXCollaboratorIdentity characterXRolIdentity) {
		this.characterXRolIdentity = characterXRolIdentity;
	}
	

	
	
	
	
	

}
