package com.albo.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.albo.test.models.entities.CharacterXRol;
import com.albo.test.models.entities.CharacterXRolIdentity;

public interface ICharacterXRolDao extends CrudRepository<CharacterXRol,CharacterXRolIdentity>, JpaSpecificationExecutor<CharacterXRol> {

}
