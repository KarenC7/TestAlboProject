package com.albo.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.albo.test.models.entities.RelatedCharacter;

public interface IRelatedCharacterDao extends CrudRepository<RelatedCharacter,Long>, JpaSpecificationExecutor<RelatedCharacter> {

}
