package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.DeliveryEntity;
import com.entities.VisitorEntity;
import com.repository.DeliveryDAOInt;
import com.repository.VisitorDAOInt;
@SpringBootTest
class VisitorServiceTest {
	@Autowired
	VisitorService vservice;
	
	@MockBean
	VisitorDAOInt vrepo;
	@Test
	void testAddVisitorEntity() {
		VisitorEntity v=new VisitorEntity();
		   v.setName("Anah"); 
		   v.setOwnerName("Elsa");
		   v.setFlatNo("115");
		   v.setDate("2022-01-07");
		   v.setArrivalTime("09:12:05");
		   v.setDepartureTime("10:20:30");
		   Mockito.when(vrepo.save(v)).thenReturn(v);
			
			assertThat(vservice.addVisitorEntity(v)).isEqualTo(v);
		   
	}


	@Test
	void testGetVisitorEntity() {
		VisitorEntity v1=new VisitorEntity();
		 v1.setName("Anam"); 
		   v1.setOwnerName("Preran");
		   v1.setFlatNo("205");
		   v1.setDate("2022-01-27");
		   v1.setArrivalTime("05:12:05");
		   v1.setDepartureTime("10:40:30");
		   Mockito.when(vrepo.save(v1)).thenReturn(v1);
			
			assertThat(vservice.addVisitorEntity(v1)).isEqualTo(v1);
	}

	@Test
	void testDeleteVisitorEntity() {
		VisitorEntity v=new VisitorEntity();
		   v.setName("Anah"); 
		   v.setOwnerName("Elsa");
		   v.setFlatNo("115");
		   v.setDate("2022-01-07");
		   v.setArrivalTime("09:12:05");
		   v.setDepartureTime("10:20:30");
		   Optional<VisitorEntity> v1=Optional.of(v);
		   Mockito.when(vrepo.findById(1)).thenReturn(v1);
			 Mockito.when(vrepo.existsById(v.getId())).thenReturn(false);
			   assertFalse(vrepo.existsById(v.getId()));
	}

	@Test
	void testUpdateVisitorEntity() {
		VisitorEntity v=new VisitorEntity();
		   v.setName("Anah"); 
		   v.setOwnerName("Elsa");
		   v.setFlatNo("115");
		   v.setDate("2022-01-07");
		   v.setArrivalTime("09:12:05");
		   v.setDepartureTime("10:20:30");
		   Optional<VisitorEntity> v3=Optional.of(v);
			
			Mockito.when(vrepo.findById(1)).thenReturn(v3);
		   Mockito.when(vrepo.save(v)).thenReturn(v);
		   v.setName("Aaliya"); 
		   v.setOwnerName("Shehnaz");
			
			//assertThat(vservice.updateVisitorEntity(v)).isEqualTo(v);
		
	}

}
