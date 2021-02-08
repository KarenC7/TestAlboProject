package com.albo.test.models.entities;

import java.util.Date;
import java.util.List;

public class CustomEntityCharacter {
	
	private Date last_sync;
	private List<Object> characters;
	public Date getLast_sync() {
		return last_sync;
	}
	public void setLast_sync(Date last_sync) {
		this.last_sync = last_sync;
	}
	public List<Object> getCharacters() {
		return characters;
	}
	public void setCharacters(List<Object> characters) {
		this.characters = characters;
	}

	

}
