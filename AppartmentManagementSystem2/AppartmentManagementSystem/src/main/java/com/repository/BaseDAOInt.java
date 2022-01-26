package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.BaseEntity;
@Repository
public interface BaseDAOInt extends JpaRepository<BaseEntity, Integer>{

	
}
