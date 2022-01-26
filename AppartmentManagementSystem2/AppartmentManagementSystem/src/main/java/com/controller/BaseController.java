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

import com.entities.BaseEntity;
import com.entities.DeliveryEntity;
import com.service.BaseService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(path="/api")
public class BaseController {
	
	@Autowired
	BaseService baseservice;
	
	@RequestMapping(path="/hello")
	//@ResponseBody
	public String hello()
	{
	 return "Welcome";	
	}
	
	@PostMapping(path="/addBaseEntity")
	public ResponseEntity<BaseEntity> addBaseEntity(@RequestBody BaseEntity base)
	{
		BaseEntity d1=baseservice.addBaseEntity(base);
		ResponseEntity re=new ResponseEntity<BaseEntity>(d1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getBaseEntities")
	public ResponseEntity<List<BaseEntity>> getBaseEntities()
	{
		List<BaseEntity> ld1=baseservice.getBaseEntities();
		ResponseEntity re=new ResponseEntity<List<BaseEntity>>(ld1,HttpStatus.OK);
		return re;
	}

	@PostMapping(path="/addBaseEntities")
	public ResponseEntity<List<BaseEntity>> addBaseEntities(@RequestBody List<BaseEntity> ldels)
	{
		List<BaseEntity> ldel=baseservice.addBaseEntities(ldels);
		
		ResponseEntity re=new ResponseEntity<List<BaseEntity>>(ldel,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getBaseEntityById/{Id}")
	public ResponseEntity<BaseEntity> getBaseEntityById(@PathVariable int Id) throws Throwable
	{
		BaseEntity d1=baseservice.getBaseEntityById(Id);
		
		ResponseEntity re=new ResponseEntity<BaseEntity>(d1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteBaseEntityById/{Id}")
	public ResponseEntity<BaseEntity> deleteBaseEntityById(@PathVariable int Id) throws Throwable
	{
		baseservice.deleteBaseEntityById(Id);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateBaseEntity")
	public ResponseEntity<BaseEntity> updateBaseEntity(@RequestBody BaseEntity e) throws Throwable
	{
		BaseEntity e1=baseservice.updateBaseEntity(e);
		
		ResponseEntity re=new ResponseEntity<BaseEntity>(e1,HttpStatus.OK);
		return re;
	}
	
	
}
