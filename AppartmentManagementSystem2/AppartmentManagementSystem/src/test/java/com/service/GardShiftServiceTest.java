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

import com.entities.GardShiftEntity;

import com.repository.GardShiftDAOInt;
@SpringBootTest
class GardShiftServiceTest {
	
	@Autowired
	GardShiftService gardshiftservice;
	
	@MockBean
	 GardShiftDAOInt gsrepo;

	

	@Test
	void testGetGardShiftEntities() {
		GardShiftEntity gs1=new GardShiftEntity();
		gs1.setUserId(3);
		gs1.setName("laxmi");
		gs1.setTime("09:19:20");
		gs1.setDate("2021-09-29");
		
		GardShiftEntity gs2=new GardShiftEntity();
		gs2.setUserId(4);
		gs2.setName("gouri");
		gs2.setTime("08:12:20");
		gs2.setDate("2021-10-29");
		List<GardShiftEntity> GardShiftEntityList = new ArrayList<>();
		GardShiftEntityList.add(gs1);
		GardShiftEntityList.add(gs2);
		
		Mockito.when(gsrepo.findAll()).thenReturn(GardShiftEntityList);
		
		assertThat(gardshiftservice.getGardShiftEntities()).isEqualTo(GardShiftEntityList);
	}
	
	@Test
	void testAddGardShiftEntity() {
		GardShiftEntity gs1=new GardShiftEntity();
		gs1.setUserId(3);
		gs1.setName("laxmi");
		gs1.setTime("09:19:20");
		gs1.setDate("2021-09-29");
		Mockito.when(gsrepo.save(gs1)).thenReturn(gs1);
		
		assertThat(gardshiftservice.addGardShiftEntity(gs1)).isEqualTo(gs1);
	}
	

	@Test
	void testUpdateGardShiftEntity() throws Throwable {
		GardShiftEntity gs1=new GardShiftEntity();
		gs1.setId(3);
		gs1.setName("kabi");
		gs1.setTime("10:19:20");
		gs1.setDate("2022-10-29");
		
Optional<GardShiftEntity> gs2=Optional.of(gs1);
		
		Mockito.when(gsrepo.findById(3)).thenReturn(gs2);
		
		Mockito.when(gsrepo.save(gs1)).thenReturn(gs1);
		gs1.setName("Madhulika");
		gs1.setTime("12:20:30");
		
		assertThat(gardshiftservice.updateGardShiftEntity(gs1)).isEqualTo(gs1);
	}
		
	
	
	

	@Test
	void testDeleteGardShiftEntity() {
		GardShiftEntity gs1=new GardShiftEntity();
		gs1.setUserId(3);
		gs1.setName("laxmi");
		gs1.setTime("09:19:20");
		gs1.setDate("2021-09-29");
		
Optional<GardShiftEntity> gs2=Optional.of(gs1);
		
		Mockito.when(gsrepo.findById(3)).thenReturn(gs2);
		 Mockito.when(gsrepo.existsById(gs1.getId())).thenReturn(false);
		   assertFalse(gsrepo.existsById(gs1.getId()));
	}
		
	}
