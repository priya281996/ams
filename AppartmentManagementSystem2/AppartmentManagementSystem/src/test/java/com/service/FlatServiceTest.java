package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.FlatEntity;
import com.entities.UserEntity;
import com.repository.FlatDAOInt;

@SpringBootTest
class FlatServiceTest {

	@Autowired
	FlatService flatservice ;
	
	@MockBean
	FlatDAOInt flatrepo;

	
	@Test
	//@Disabled
	void testgetFlatEntities() {
		FlatEntity c1=new FlatEntity();
		c1.setOwnerName("rekha");
		c1.setFlatNo("10215");
		c1.setFloorNo("15");
		c1.setFlatType("2BHK");
	
		FlatEntity c2=new FlatEntity();
		c2.setOwnerName("ramya");
		c2.setFlatNo("1542");
		c2.setFloorNo("10");
		c2.setFlatType("3BHK");
		
		
		List<FlatEntity> ul = new ArrayList<>();
		ul.add(c1);
		ul.add(c2);
		
		Mockito.when(flatrepo.findAll()).thenReturn(ul);
		
		assertThat(flatservice.getFlatEntities()).isEqualTo(ul);
	}

	
	@Test
	//@Disabled
	void testaddFlatEntity() {
		FlatEntity c1=new FlatEntity();
		c1.setOwnerName("rekha");
		c1.setFlatNo("10215");
		c1.setFloorNo("15");
		c1.setFlatType("2BHK");
		
	Mockito.when(flatrepo.save(c1)).thenReturn(c1);
		
		assertThat(flatservice.addFlatEntity(c1)).isEqualTo(c1);
	}
	
	
	@Test
	//@Disabled
	void testupdateFlatEntity() throws Throwable {
		FlatEntity c1=new FlatEntity();
		c1.setOwnerName("rekha");
		c1.setFlatNo("10215");
		c1.setFloorNo("15");
		c1.setFlatType("2BHK");
		
		Optional<FlatEntity> c2=Optional.of(c1);
		
		Mockito.when(flatrepo.findById(1)).thenReturn(c2);
		
		Mockito.when(flatrepo.save(c1)).thenReturn(c1);
		c1.setOwnerName("kavya");
		c1.setFlatNo("1452");
		c1.setFloorNo("5");
		c1.setFlatType("4BHK");
		
		assertThat(flatservice.updateFlatEntity(c1)).isEqualTo(c1);
	}
	
	@Test
	//@Disabled
	void testDeleteUserEntity() {
		FlatEntity c1=new FlatEntity();
		c1.setOwnerName("rekha");
		c1.setFlatNo("10215");
		c1.setFloorNo("15");
		c1.setFlatType("2BHK");
		Optional<FlatEntity> c2=Optional.of(c1);
		
		Mockito.when(flatrepo.findById(1)).thenReturn(c2);
		 Mockito.when(flatrepo.existsById((int) c1.getId())).thenReturn(false);
		   assertFalse(flatrepo.existsById((int) c1.getId()));
	}

}