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

import com.entities.VehicleEntity;
import com.repository.VehicleDAOInt;
import com.service.VehicleService;


@SpringBootTest
class VehicleServiceTest {

	
	@Autowired
	VehicleService vehicleservice;
	
	
	@MockBean
	VehicleDAOInt repo;
	
	
	
	@Test
	
	void testgetVehicleEntity() {
		VehicleEntity v1=new VehicleEntity();
		v1.setName("Bajaj");
		v1.setParkingNo("123");
		v1.setArrivalTime("09:15");
		v1.setDepartureTime("06:15");
		v1.setDate("2022-01-05");
		v1.setVehicleNo("KA01M2343");
		v1.setVehicleType("Gear");
		
		VehicleEntity v2=new VehicleEntity();
		v2.setName("Hero");
		v2.setParkingNo("456");
		v2.setArrivalTime("07:15");
		v2.setDepartureTime("08:15");
		v2.setDate("2022-01-09");
		v2.setVehicleNo("KA01M3343");
		v2.setVehicleType("Non Gear");
		
		List<VehicleEntity> VehicleList = new ArrayList<>();
		VehicleList.add(v1);
		VehicleList.add(v2);
		
		Mockito.when(repo.findAll()).thenReturn(VehicleList);
		
		assertThat(vehicleservice.getVehicleEntities()).isEqualTo(VehicleList);
	}
		
	//@Test
	//@Disabled
	/*
	 * void testgetVehicleEntityById() throws Throwable {
	 * 
	 * VehicleEntity v1=new VehicleEntity(); v1.setName("Bajaj");
	 * v1.setParkingNo("123"); v1.setArrivalTime("09:15");
	 * v1.setDepartureTime("06:15"); v1.setDate("2022-01-05");
	 * v1.setVehicleNo("KA01M2343"); v1.setVehicleType("Gear");
	 * 
	 * 
	 * Optional<VehicleEntity> v2=Optional.of(v1);
	 * 
	 * Mockito.when(repo.findById(1)).thenReturn(v2);
	 * 
	 * assertThat(vehicleservice.getVehicleEntityByname(1)).isEqualTo(v1); }
	 */
		
	@Test
	
	void testAddVehicleEntity() {
		VehicleEntity v1=new VehicleEntity(); 
		v1.setName("Bajaj");
		v1.setParkingNo("123");
		v1.setArrivalTime("09:15");
		v1.setDepartureTime("06:15");
		v1.setDate("2022-01-05");
		v1.setVehicleNo("KA01M2343");
		v1.setVehicleType("Gear");
	   Mockito.when(repo.save(v1)).thenReturn(v1);
		
		assertThat(vehicleservice.addVehicleEntity(v1)).isEqualTo(v1);
	}
	
	@Test
	void testUpdateVehicleEntity() throws Throwable {
		VehicleEntity v1=new VehicleEntity(); 
		v1.setName("Bajaj");
		v1.setParkingNo("123");
		v1.setArrivalTime("09:15");
		v1.setDepartureTime("06:15");
		v1.setDate("2022-01-05");
		v1.setVehicleNo("KA01M2343");
		v1.setVehicleType("Gear");
		Optional<VehicleEntity> v2=Optional.of(v1);
		
		//Mockito.when(repo.findByName("Bajaj")).thenReturn(v2);
	
		Mockito.when(repo.save(v1)).thenReturn(v1);
		v1.setName("Honda");
		v1.setParkingNo("456");
		v1.setArrivalTime("08:15");
		v1.setDepartureTime("05:15");
		v1.setDate("2022-01-04");
		v1.setVehicleNo("KA01M89343");
		v1.setVehicleType("Non Bike Gear");
		
		//assertThat(vehicleservice.updateVehicleEntity(v1)).isEqualTo(v1);
	}
	
	@Test
	//@Disabled
	void testDeleteVehicleEntity() {
		VehicleEntity v1=new VehicleEntity(); 
		v1.setName("Bajaj");
		v1.setParkingNo("123");
		v1.setArrivalTime("09:15");
		v1.setDepartureTime("06:15");
		v1.setDate("2022-01-05");
		v1.setVehicleNo("KA01M2343");
		v1.setVehicleType("Gear");
		Optional<VehicleEntity> v2=Optional.of(v1);
		
		Mockito.when(repo.findById(1)).thenReturn(v2);
		// Mockito.when(repo.existsById(v1.getName())).thenReturn(false);
		  // assertFalse(repo.existsById(v1.getName()));
	}



}