package com.spring.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.spring.test.models.entities.CharacterXRolXCollaborator;
import com.spring.test.models.entities.CharacterXRolXCollaboratorIdentity;

public interface ICharacterXRolXCollaboratorDao extends CrudRepository<CharacterXRolXCollaborator,CharacterXRolXCollaboratorIdentity>, JpaSpecificationExecutor<CharacterXRolXCollaborator> {

}
