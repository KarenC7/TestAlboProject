package com.albo.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.albo.test.models.entities.Rol;

public interface IRolDao extends CrudRepository<Rol,Long>, JpaSpecificationExecutor<Rol> {

}