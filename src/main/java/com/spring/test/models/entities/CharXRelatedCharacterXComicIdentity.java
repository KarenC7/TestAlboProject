package com.spring.test.models.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CharXRelatedCharacterXComicIdentity implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private Long idCharacter;
	
    private Long idRelated;
    
    private Long idComic;
    
    
	public CharXRelatedCharacterXComicIdentity()  {

    }

    public CharXRelatedCharacterXComicIdentity(Long idCharacter, Long idRelated,Long idComic) {
        this.idCharacter = idCharacter;
        this.idRelated = idRelated;
        this.idComic = idComic;
    }

	public Long getIdCharacter() {
		return idCharacter;
	}

	public void setIdCharacter(Long idCharacter) {
		this.idCharacter = idCharacter;
	}

	public Long getIdRelated() {
		return idRelated;
	}

	public void setIdRelated(Long idRelatedCharacter) {
		this.idRelated = idRelatedCharacter;
	}

	public Long getIdComic() {
		return idComic;
	}

	public void setIdComic(Long idComic) {
		this.idComic = idComic;
	}
    
    

}
