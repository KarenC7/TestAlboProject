package com.albo.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.albo.test.models.entities.ComicCharacter;


public interface IComicCharacterDao extends CrudRepository<ComicCharacter,Long>, JpaSpecificationExecutor<ComicCharacter> {

}
