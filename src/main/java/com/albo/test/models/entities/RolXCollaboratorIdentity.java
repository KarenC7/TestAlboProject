package com.albo.test.models.entities;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable

public class RolXCollaboratorIdentity implements Serializable {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Long idCollaborator;
		
    private Long idRol;
    
    
	public RolXCollaboratorIdentity() {

    }

    public RolXCollaboratorIdentity(Long idCollaborator, Long idRol) {
        this.idCollaborator = idCollaborator;
        this.idRol = idRol;
    }

    

    public Long getIdCollaborator() {
		return idCollaborator;
	}

	public void setIdCollaborator(Long idCollaborator) {
		this.idCollaborator = idCollaborator;
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

        RolXCollaboratorIdentity that = (RolXCollaboratorIdentity) o;

        if (idCollaborator!=that.idCollaborator) return false;
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