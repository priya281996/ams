package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.VisitorEntity;

@Repository
public interface VisitorDAOInt extends JpaRepository<VisitorEntity, Integer> {

}
