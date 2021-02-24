package com.spring.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.spring.test.models.entities.CharXRelatedCharacterXComic;
import com.spring.test.models.entities.CharXRelatedCharacterXComicIdentity;

public interface ICharXRelatedCharacterXComicDao extends CrudRepository<CharXRelatedCharacterXComic,CharXRelatedCharacterXComicIdentity>, JpaSpecificationExecutor<CharXRelatedCharacterXComic> {

}
