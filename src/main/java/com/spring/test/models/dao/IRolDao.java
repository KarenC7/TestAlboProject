package com.spring.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.spring.test.models.entities.Rol;

public interface IRolDao extends CrudRepository<Rol,Long>, JpaSpecificationExecutor<Rol> {

}