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

import com.entities.FlatRentEntity;
import com.repository.FlatDAOInt;
import com.repository.FlatRentDAO;
import com.service.FlatRentService;

@SpringBootTest
class FlatRentTest {

	@Autowired
	FlatRentService flatrentservice;
	@MockBean
	FlatRentDAO frepo;
	
	@Test
	void testAddFlatRentEntity () {
		FlatRentEntity f=new FlatRentEntity();
		f.setOwnerName("Mona");
		f.setFlatNo("101");
		f.setAmount("12000");
		f.setType("First Floor");
        Mockito.when(frepo.save(f)).thenReturn(f);
		
		assertThat(flatrentservice.addFlatRentEntity(f)).isEqualTo(f);
		}
	
	
	@Test
	//@Disabled
	void testGetFlatRentEntity() {
		FlatRentEntity f1=new FlatRentEntity();
		f1.setOwnerName("Sona");
		f1.setFlatNo("102");
		f1.setAmount("7000");
		f1.setType("Second Floor");
		
		FlatRentEntity f2=new FlatRentEntity();
		f2.setOwnerName("Dona");
		f2.setFlatNo("103");
		f2.setAmount("8000");
		f2.setType("Third Floor");
		
		List<FlatRentEntity> flatRentEntityList = new ArrayList<>();
        Mockito.when(frepo.findAll()).thenReturn(flatRentEntityList);
        assertThat(flatrentservice.getFlatRentEntities()).isEqualTo(flatRentEntityList);
		}
		
	@Test
	//@Disabled
	void testUpdateFlatRentEntity() {
		FlatRentEntity f7=new FlatRentEntity();
		f7.setOwnerName("Sona");
		f7.setFlatNo("102");
		f7.setAmount("7000");
		f7.setType("Second Floor");
		
		Optional<FlatRentEntity> f5=Optional.of(f7);
       Mockito.when(frepo.findById(1)).thenReturn(f5);
		Mockito.when(frepo.save(f7)).thenReturn(f7);
		
		f7.setOwnerName("Madhu");
		f7.setFlatNo("105");
		f7.setAmount("6000");
		f7.setType("Last Floor");
		//assertThat(flatrentservice.updateFlatRentEntity(f7)).isEqualTo(f5);
		
	}
	
	@Test
	//@Disabled
	void testDeleteFlatRentEntity() {
		FlatRentEntity f7=new FlatRentEntity();
		f7.setOwnerName("Sona");
		f7.setFlatNo("102");
		f7.setAmount("7000");
		f7.setType("Second Floor");
		Optional<FlatRentEntity> f5=Optional.of(f7);
		
		Mockito.when(frepo.findById(1)).thenReturn(f5);
		Mockito.when(frepo.save(f7)).thenReturn(f7);
		// Mockito.when(frepo.exists(f7.getOwnerName())).thenReturn(false);
		//assertFalse(frepo.existsById(f7.getOwnerName()));
	
   }
}
