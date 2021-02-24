package com.spring.test.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.spring.test.models.entities.Comic;

public interface IComicDao extends CrudRepository<Comic,Long>, JpaSpecificationExecutor<Comic> {

}
