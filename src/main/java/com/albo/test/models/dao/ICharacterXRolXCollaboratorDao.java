package com.albo.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.albo.test.models.entities.CharacterXRolXCollaborator;
import com.albo.test.models.entities.CharacterXRolXCollaboratorIdentity;

public interface ICharacterXRolXCollaboratorDao extends CrudRepository<CharacterXRolXCollaborator,CharacterXRolXCollaboratorIdentity>, JpaSpecificationExecutor<CharacterXRolXCollaborator> {

}
