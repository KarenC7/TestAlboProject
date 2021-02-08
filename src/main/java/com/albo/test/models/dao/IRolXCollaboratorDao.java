package com.albo.test.models.dao;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import com.albo.test.models.entities.RolXCollaborator;
import com.albo.test.models.entities.RolXCollaboratorIdentity;

public interface IRolXCollaboratorDao extends CrudRepository<RolXCollaborator,RolXCollaboratorIdentity>, JpaSpecificationExecutor<RolXCollaborator> {

}
