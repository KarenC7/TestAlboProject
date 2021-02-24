package com.spring.test.models.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "charxrelatedxcomic")
public class CharXRelatedCharacterXComic {
	@EmbeddedId
    private CharXRelatedCharacterXComicIdentity characterXRelatedIdentity;
	
	@OneToOne
    @JoinColumn(name="idCharacter", insertable=false, updatable=false)
    private ComicCharacter character;
	
	@OneToOne
    @JoinColumn(name="idComic", insertable=false, updatable=false)
    private Comic comic;
	
	@OneToOne
    @JoinColumn(name="idRelated", insertable=false, updatable=false)
    private RelatedCharacter related;
	
	
	
	public RelatedCharacter getRelated() {
		return related;
	}

	public void setRelated(RelatedCharacter related) {
		this.related = related;
	}

	public ComicCharacter obtenerCharacter() {
		return character;
	}

	public void setCharacter(ComicCharacter character) {
		this.character = character;
	}

	public Comic getComic() {
		return comic;
	}

	public void setComic(Comic comic) {
		this.comic = comic;
	}

	public CharXRelatedCharacterXComicIdentity obtenerCharacterXRelatedIdentity() {
		return characterXRelatedIdentity;
	}

	public void setCharacterXRelatedIdentity(CharXRelatedCharacterXComicIdentity characterXRelatedIdentity) {
		this.characterXRelatedIdentity = characterXRelatedIdentity;
	}
	
	
	

}
