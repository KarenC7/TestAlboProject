package com.spring.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.spring.test.models.entities.RelatedCharacter;

public interface IRelatedCharacterDao extends CrudRepository<RelatedCharacter,Long>, JpaSpecificationExecutor<RelatedCharacter> {

}
