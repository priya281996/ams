package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.VehicleEntity;
import com.service.VehicleService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin("*")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleservice;
	
	
	@PostMapping("/addVehicleEntity")
	public ResponseEntity<VehicleEntity> addVehicleEntity(@RequestBody VehicleEntity v)
	{
		VehicleEntity v1=vehicleservice.addVehicleEntity(v);
		ResponseEntity re=new ResponseEntity<VehicleEntity>(v1,HttpStatus.OK);
		return re;
	}

	@PostMapping(path="/addVehicleEntities")
	public ResponseEntity<List<VehicleEntity>> addVehicleEntities(@RequestBody List<VehicleEntity> ls)
	{
		List<VehicleEntity> le=vehicleservice.addVehicleEntities(ls);
		
		ResponseEntity re=new ResponseEntity<List<VehicleEntity>>(le, HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getVehicleEntity")
	public ResponseEntity<List<VehicleEntity>> getVehicleEntity()
	{
		List<VehicleEntity> lc1=vehicleservice.getVehicleEntities();
		ResponseEntity re=new ResponseEntity<List<VehicleEntity>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateVehicleEntity")
	public ResponseEntity<VehicleEntity> updateVehicleEntity(@RequestBody VehicleEntity e) throws Exception
	{
		VehicleEntity e1=vehicleservice.updateVehicleEntity(e);
		
		ResponseEntity re=new ResponseEntity<VehicleEntity>(e1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getVehicle/{id}")
	public ResponseEntity<VehicleEntity> getVehicleEntityById(@PathVariable int id) throws Exception
	{
		VehicleEntity d1=vehicleservice.getVehicleEntityById(id);
		
		ResponseEntity re=new ResponseEntity<VehicleEntity>(d1,HttpStatus.OK);
		return re;
	}
	
	
	@DeleteMapping(path="/deleteVehicle")
	public ResponseEntity<String> deleteVehicle(@RequestBody VehicleEntity e)
	{
		vehicleservice.deleteVehicle(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
		
	@DeleteMapping(path="/deleteVehicleEntityById/{id}")
	public ResponseEntity<VehicleEntity> deleteVehicleEntityById(@PathVariable int id) throws Throwable
	{
	 	vehicleservice.deleteVehicleEntityById(id);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
}