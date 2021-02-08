package com.albo.test.models.entities;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable

public class CharacterXRolIdentity implements Serializable {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Long idCharacter;
		
    private Long idRol;
    
    
	public CharacterXRolIdentity() {

    }

    public CharacterXRolIdentity(Long idCharacter, Long idRol) {
        this.idCharacter = idCharacter;
        this.idRol = idRol;
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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterXRolIdentity that = (CharacterXRolIdentity) o;

        if (idCharacter!=that.idCharacter) return false;
        return idRol==that.idRol;
    }
/*
    @Override
    public int hashCode() {
        int result = employeeId.hashCode();
        result = 31 * result + companyId.hashCode();
        return result;
    }
    */
}