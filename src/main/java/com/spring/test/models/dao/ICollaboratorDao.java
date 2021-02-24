package com.spring.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.spring.test.models.entities.Collaborator;

public interface ICollaboratorDao extends CrudRepository<Collaborator,Long>, JpaSpecificationExecutor<Collaborator> {

}
