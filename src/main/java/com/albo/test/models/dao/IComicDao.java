package com.albo.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.albo.test.models.entities.Comic;

public interface IComicDao extends CrudRepository<Comic,Long>, JpaSpecificationExecutor<Comic> {

}
