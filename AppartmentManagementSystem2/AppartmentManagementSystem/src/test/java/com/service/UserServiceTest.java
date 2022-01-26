package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.UserEntity;
import com.repository.UserDAOInt;

@SpringBootTest
class UserServiceTest {

	@Autowired
	UserService userservice ;
	
	@MockBean
	UserDAOInt userrepo;

	@Test
	//@Disabled
	void testGetUser() {
		UserEntity c1=new UserEntity();
		c1.setFirstName("rekha");
		c1.setLastName("shankar");
		c1.setLoginId("log101");
		c1.setPassword("adahv");
		c1.setMobileNo("9876543210");
		c1.setEmailId("abc@gmail.com");
		//c1.setRoleId(1);
		
		UserEntity c2=new UserEntity();
		c2.setFirstName("rashmi");
		c2.setLastName("sr");
		c2.setLoginId("log102");
		c2.setPassword("trejs");
		c2.setMobileNo("9876543562");
		c2.setEmailId("def@gmail.com");
		//c2.setRoleId(2);
		
		List<UserEntity> ul = new ArrayList<UserEntity>();
		ul.add(c1);
		ul.add(c2);
		
		Mockito.when(userrepo.findAll()).thenReturn(ul);
		
		assertThat(userservice.getUser()).isEqualTo(ul);
	}

	
	@Test
	//@Disabled
	void testAddUser() {
		UserEntity c1=new UserEntity();
		c1.setFirstName("rekha");
		c1.setLastName("shankar");
		c1.setLoginId("log101");
		c1.setPassword("adahv");
		c1.setMobileNo("9876543210");
		c1.setEmailId("abc@gmail.com");
		c1.setRoleId(1);
	Mockito.when(userrepo.save(c1)).thenReturn(c1);
		
		assertThat(userservice.addUser(c1)).isEqualTo(c1);
	}

	@Test
	//@Disabled
	void testUpdateUser() throws Throwable {
		UserEntity c1=new UserEntity();
		c1.setFirstName("rekha");
		c1.setLastName("shankar");
		c1.setLoginId("log101");
		c1.setPassword("adahv");
		c1.setMobileNo("9876543210");
		c1.setEmailId("abc@gmail.com");
		c1.setId(1);
		Optional<UserEntity> c2=Optional.of(c1);
		
		Mockito.when(userrepo.findById(1)).thenReturn(c2);
		
		Mockito.when(userrepo.save(c1)).thenReturn(c1);
		c1.setFirstName("ramya");
		c1.setLastName("fd");
		c1.setLoginId("log103");
		c1.setPassword("qwer");
		c1.setMobileNo("9876545687");
		c1.setEmailId("fgh@gmail.com");
		
		assertThat(userservice.updateUser(c1)).isEqualTo(c1);
	}

	@Test
	//@Disabled
	void testDeleteUserEntity() {
		UserEntity c1=new UserEntity();
		c1.setFirstName("rekha");
		c1.setLastName("shankar");
		c1.setLoginId("log101");
		c1.setPassword("adahv");
		c1.setMobileNo("9876543210");
		c1.setEmailId("abc@gmail.com");
		c1.setRoleId(1);
		Optional<UserEntity> c2=Optional.of(c1);
		
		Mockito.when(userrepo.findById(1)).thenReturn(c2);
		 Mockito.when(userrepo.existsById((int) c1.getRoleId())).thenReturn(false);
		   assertFalse(userrepo.existsById((int) c1.getRoleId()));
	}

}

