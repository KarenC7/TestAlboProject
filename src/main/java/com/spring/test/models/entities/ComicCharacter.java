package com.spring.test.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "characters")
public class ComicCharacter {
	@Id
	@Column(name = "ID_CHARACTER", nullable = false)
	private Long idCharacter;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LAST_SYNC")
	private Date lastSync;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="character")
    private List<CharacterXRolXCollaborator> collaborators;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="character")
    private List<CharXRelatedCharacterXComic> comics;
	

	
	
	public List<CharacterXRolXCollaborator> getCollaborators() {
		return collaborators;
	}
	public void setCollaborators(List<CharacterXRolXCollaborator> collaborators) {
		this.collaborators = collaborators;
	}
	public List<CharXRelatedCharacterXComic> getComics() {
		return comics;
	}
	public void setComics(List<CharXRelatedCharacterXComic> comics) {
		this.comics = comics;
	}
	
	public Long getIdCharacter() {
		return idCharacter;
	}
	public void setIdCharacter(Long idCharacter) {
		this.idCharacter = idCharacter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLastSync() {
		return lastSync;
	}
	public void setLastSync(Date lastSync) {
		this.lastSync = lastSync;
	}
	@Override
	public String toString() {
		return "ComicCharacter [idCharacter=" + idCharacter + ", name=" + name + ", lastSync=" + lastSync + "]";
	}
	
	
	
	
	
	
	


}
