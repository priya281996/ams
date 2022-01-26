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
import com.entities.DeliveryEntity;
import com.repository.DeliveryDAOInt;
@SpringBootTest
class DeliveryServiceTest {

	@Autowired
	DeliveryService deliveryservice;
	
	@MockBean
	DeliveryDAOInt delrepo;
	@Test
	void testAddDeliveryEntity() {
		DeliveryEntity d=new DeliveryEntity();
		d.setOwnerName("Mona");
		d.setTime("19:20");
		d.setDate("2022-01-06");
		d.setStatus("Delivered");
        Mockito.when(delrepo.save(d)).thenReturn(d);
		
		assertThat(deliveryservice.addDeliveryEntity(d)).isEqualTo(d);
		}

	@Test
	void testGetDeliveryEntities() {
		DeliveryEntity d1=new DeliveryEntity();
		d1.setOwnerName("Sona");
		d1.setTime("09:40");
		d1.setDate("2022-02-08");
		d1.setStatus("Reached");
		
		DeliveryEntity d2=new DeliveryEntity();
		d2.setOwnerName("Dona");
		d2.setTime("07:20");
		d2.setDate("2022-12-18");
		d2.setStatus("Reached");
		
		List<DeliveryEntity> deliveryentityList = new ArrayList<>();
        Mockito.when(delrepo.findAll()).thenReturn(deliveryentityList);
		
		assertThat(deliveryservice.getDeliveryEntities()).isEqualTo(deliveryentityList);
		}
	
	

	@Test
	void testUpdateDeliveryEntity() {
		DeliveryEntity d5=new DeliveryEntity();
		d5.setOwnerName("Sona");
		d5.setTime("09:40");
		d5.setDate("2022-02-08");
		d5.setStatus("Reached");
		Optional<DeliveryEntity> d2=Optional.of(d5);
		
       Mockito.when(delrepo.findById(1)).thenReturn(d2);
		
		Mockito.when(delrepo.save(d5)).thenReturn(d5);
		d5.setOwnerName("Madhu");
		
		d5.setStatus("Delivered");
		
		
			//assertThat(deliveryservice.updateDeliveryEntity(d5)).isEqualTo(d5);
		
	}

}
