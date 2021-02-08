package com.albo.test.models.entities;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "characterxrol")
public class CharacterXRol {
	@EmbeddedId
    private CharacterXRolIdentity characterXRolIdentity;

	@OneToOne
    @JoinColumn(name="idCharacter", insertable=false, updatable=false)
    private ComicCharacter character;
	
	@OneToOne
    @JoinColumn(name="idRol", insertable=false, updatable=false)
    private Rol rol;
	
	
	
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

	public CharacterXRolIdentity obtenerCharacterXRolIdentity() {
		return characterXRolIdentity;
	}

	public void setCharacterXRolIdentity(CharacterXRolIdentity characterXRolIdentity) {
		this.characterXRolIdentity = characterXRolIdentity;
	}
	

	
	
	
	
	

}
