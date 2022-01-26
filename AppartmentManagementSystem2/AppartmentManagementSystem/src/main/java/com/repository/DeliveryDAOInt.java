package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.DeliveryEntity;
import com.service.DeliveryService;

@Repository
public interface DeliveryDAOInt extends JpaRepository<DeliveryEntity, Integer>{

	//DeliveryEntity findByName();	
}
