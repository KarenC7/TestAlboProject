package com.albo.test.models.entities;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable

public class CharacterXRolXCollaboratorIdentity implements Serializable {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Long idCharacter;
		
    private Long idRol;
    
    private Long idCollaborator;
    
    
	public CharacterXRolXCollaboratorIdentity() {

    }

    public CharacterXRolXCollaboratorIdentity(Long idCharacter, Long idRol,Long idCollaborator) {
        this.idCharacter = idCharacter;
        this.idRol = idRol;
        this.idCollaborator = idCollaborator;
    }

    

    public Long getIdCollaborator() {
		return idCollaborator;
	}

	public void setIdCollaborator(Long idCollaborator) {
		this.idCollaborator = idCollaborator;
	}

	public Long getIdCharacter() {
		return idCharacter;
	}

	public void setIdCharacter(Long idCharacter) {
		this.idCharacter = idCharacter;
	}

	
	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	
}