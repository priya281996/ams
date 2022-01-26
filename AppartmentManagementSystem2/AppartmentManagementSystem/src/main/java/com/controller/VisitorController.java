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

import com.entities.DeliveryEntity;
import com.entities.VehicleEntity;
import com.entities.VisitorEntity;
import com.service.VehicleService;
import com.service.VisitorService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin("*")
public class VisitorController {

	@Autowired
	VisitorService visitorservice;
	
	@PostMapping("/addVisitorEntity")
	public ResponseEntity<VisitorEntity> addVisitorEntity(@RequestBody VisitorEntity v)
	{
		VisitorEntity v1=visitorservice.addVisitorEntity(v);
		ResponseEntity re=new ResponseEntity<VisitorEntity>(v1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addVisitorEntities")
	public ResponseEntity<List<VisitorEntity>> addVisitorEntities(@RequestBody List<VisitorEntity> ls)
	{
		List<VisitorEntity> le=visitorservice.addVisitorEntities(ls);
		
		ResponseEntity re=new ResponseEntity<List<VisitorEntity>>(le, HttpStatus.OK);
		return re;
	}
	@GetMapping("/getVisitorEntities")
	public ResponseEntity<List<VisitorEntity>> getVisitorEntities()
	{
		List<VisitorEntity> lc1=visitorservice.getVisitorEntities();
		ResponseEntity re=new ResponseEntity<List<VisitorEntity>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateVisitorEntity")
	public ResponseEntity<VisitorEntity> updateVisitorEntity(@RequestBody VisitorEntity e) throws Exception
	{
		VisitorEntity e1=visitorservice.updateVisitorEntity(e);
		ResponseEntity re=new ResponseEntity<VisitorEntity>(e1,HttpStatus.OK);
		return re;
	}
	
	
	
	@DeleteMapping(path="/deleteVisitorEntityById/{id}")
	public ResponseEntity<VisitorEntity> deleteVisitorEntityById(@PathVariable int id) throws Throwable
	{
		visitorservice.deleteVisitorEntityById(id);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
}
