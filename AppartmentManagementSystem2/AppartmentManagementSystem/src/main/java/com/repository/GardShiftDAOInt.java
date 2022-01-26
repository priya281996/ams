package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.GardShiftEntity;


@Repository
public interface GardShiftDAOInt extends JpaRepository<GardShiftEntity, Integer>{

	
	
	
}