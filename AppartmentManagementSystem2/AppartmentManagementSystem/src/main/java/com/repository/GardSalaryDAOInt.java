package com.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.GardSalaryEntity;



@Repository
public interface GardSalaryDAOInt extends JpaRepository<GardSalaryEntity, Integer>  {

	
	
}