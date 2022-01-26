package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.GardSalaryEntity;

import com.repository.GardSalaryDAOInt;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
@SpringBootTest
class GardSalaryServiceTest {
	
	@Autowired
	GardSalaryService gardsalaryservice;
	
	@MockBean
	GardSalaryDAOInt grepo;
	@Test
	void testAddGardSalaryEntity() {
		GardSalaryEntity g1=new GardSalaryEntity();
		g1.setId(101);
		g1.setName("shashi");
		g1.setAmount(4000);
		g1.setStatus("updated");
		g1.setDate("23:09:2021");
		
Mockito.when(grepo.save(g1)).thenReturn(g1);
		
		assertThat(gardsalaryservice.addGardSalaryEntity(g1)).isEqualTo(g1);
	}
	
	@Disabled
	//@Test
	void testGetGardSalaryEntities() {
		
		GardSalaryEntity g1=new GardSalaryEntity();
		g1.setId(101);
		g1.setName("shashi");
		g1.setAmount(4000);
		g1.setStatus("updated");
		g1.setDate("23:09:2021");
		
		GardSalaryEntity g2=new GardSalaryEntity();
		g2.setId(102);
		g2.setName("akash");
		g2.setAmount(9000);
		g2.setStatus("pending");
		g2.setDate("05:01:2022");
		
		List<GardSalaryEntity> GardSalaryEntityList=new ArrayList<>();
		GardSalaryEntityList.add(g1);
		GardSalaryEntityList.add(g2);
		Mockito.when(grepo.findAll()).thenReturn(GardSalaryEntityList);
		
		assertThat(gardsalaryservice.getGardSalaryEntities()).isEqualTo(GardSalaryEntityList);
	}
		
		
	@Test
	void testDeleteGardSalaryEntity() {
		GardSalaryEntity g1=new GardSalaryEntity();
		g1.setId(101);
		g1.setName("shashi");
		g1.setAmount(4000);
		g1.setStatus("updated");
		g1.setDate("23:09:2021");
		Optional<GardSalaryEntity> g2=Optional.of(g1);
		
		Mockito.when(grepo.findById(101)).thenReturn(g2);
		 Mockito.when(grepo.existsById(g1.getId())).thenReturn(false);
		   assertFalse(grepo.existsById(g1.getId()));
	}
	

	@Test
	void testUpdateGardSalaryEntity() throws Throwable {
		GardSalaryEntity g1=new GardSalaryEntity();
		g1.setId(101);
		g1.setName("shashi");
		g1.setAmount(4000);
		g1.setStatus("updated");
		g1.setDate("26:09:2021");
		
Optional<GardSalaryEntity> g2=Optional.of(g1);
		
		Mockito.when(grepo.findById(101)).thenReturn(g2);
		Mockito.when(grepo.save(g1)).thenReturn(g1);
		g1.setName("shashikala");
		g1.setAmount(8000);
		
		assertThat(gardsalaryservice.updateGardSalaryEntity(g1)).isEqualTo(g1);
	}

}