package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.UserEntity;
public interface UserDAOInt extends JpaRepository <UserEntity,Integer>
{
	UserEntity getUserEntityByFirstName(String firstname);

	UserEntity getUserEntityByLastName(String lastname);
}
