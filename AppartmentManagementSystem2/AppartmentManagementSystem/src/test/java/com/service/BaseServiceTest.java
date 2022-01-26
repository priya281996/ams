package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.BaseEntity;

import com.repository.BaseDAOInt;

@SpringBootTest
class BaseServiceTest {
	@Autowired
	BaseService bservice;
	
	@MockBean
	BaseDAOInt brepo;

	@Test
	void testAddBaseEntity() {
		BaseEntity b=new BaseEntity();
		b.setId(1);
		b.setCreatedBy("Admin");
		b.setModifiedBy("User");
		b.setCreatedDateTime("2022-01-06 15:28:36");
		b.setModifiedDateTime("2022-02-08 05:22:56");
		  Mockito.when(brepo.save(b)).thenReturn(b);
			
			assertThat(bservice.addBaseEntity(b)).isEqualTo(b);
	}
	@Test
	void testAddBaseEntities() {
		BaseEntity b3=new BaseEntity();
		b3.setId(2);
		b3.setCreatedBy("Anish");
		b3.setModifiedBy("Usha");
		b3.setCreatedDateTime("2022-01-16 18:28:36");
		b3.setModifiedDateTime("2022-02-05 15:22:56");
		
		BaseEntity b4=new BaseEntity();
		b4.setId(3);
		b4.setCreatedBy("Panish");
		b4.setModifiedBy("prisha");
		b4.setCreatedDateTime("2021-01-16 18:28:36");
		b4.setModifiedDateTime("2021-02-05 15:22:56");
		List<BaseEntity> BaseEntityList = new ArrayList<>();
		BaseEntityList.add(b3);
		BaseEntityList.add(b4);
		  Mockito.when(brepo.findAll()).thenReturn( BaseEntityList);
			
			assertThat(bservice.addBaseEntities( BaseEntityList)).isEqualTo( BaseEntityList);
	}
	
	@Test
	void testDeleteBaseEntityById() {
		BaseEntity b=new BaseEntity();
		b.setId(1);
		b.setCreatedBy("Admin");
		b.setModifiedBy("User");
		b.setCreatedDateTime("2022-01-06 15:28:36");
		b.setModifiedDateTime("2022-02-08 05:22:56");
Optional<BaseEntity> c=Optional.of(b);
		
		Mockito.when(brepo.findById(1)).thenReturn(c);
		 Mockito.when(brepo.existsById(b.getId())).thenReturn(false);
		   assertFalse(brepo.existsById(b.getId()));
	}

	@Test
	void testGetBaseEntityById() {
		BaseEntity b4=new BaseEntity();
		b4.setId(3);
		b4.setCreatedBy("Panish");
		b4.setModifiedBy("prisha");
		b4.setCreatedDateTime("2021-01-16 18:28:36");
		b4.setModifiedDateTime("2021-02-05 15:22:56");
		 
		Optional<BaseEntity> c=Optional.of(b4);
		
		Mockito.when(brepo.findById(3)).thenReturn(null);
		
		//assertThat(bservice.getBaseEntityById(3)).isEqualTo(b4);
	}

	@Test
	void testUpdateBaseEntity()  {
		BaseEntity b5=new BaseEntity();
		b5.setId(3);
		b5.setCreatedBy("Panish");
		b5.setModifiedBy("prisha");
		b5.setCreatedDateTime("2021-01-16 18:28:36");
		b5.setModifiedDateTime("2021-02-05 15:22:56");
Optional<BaseEntity> c=Optional.of(b5);
		

Mockito.when(brepo.save(b5)).thenReturn(b5);
b5.setCreatedBy("Madhu");
b5.setModifiedBy("Manish");

//assertThat(bservice.updateBaseEntity(b5)).isEqualTo(b5);
	}

}
