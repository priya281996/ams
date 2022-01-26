package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.FlatEntity;

@Repository

public interface FlatDAOInt extends JpaRepository<FlatEntity, Integer> {

	
	
}

