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
import com.entities.UserEntity;
import com.repository.DeliveryDAOInt;
import com.service.DeliveryService;
@CrossOrigin("*")
@RestController
@RequestMapping(path="/api")

public class DeliveryController {
	
	@Autowired
	DeliveryService deliveryservice;
	
	@PostMapping(path="/addDeliveryEntity")
	public ResponseEntity<DeliveryEntity> addDeliveryEntity(@RequestBody DeliveryEntity del)
	{
		DeliveryEntity d1=deliveryservice.addDeliveryEntity(del);
		ResponseEntity re=new ResponseEntity<DeliveryEntity>(d1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getDeliveryEntities")
	public ResponseEntity<List<DeliveryEntity>> getDeliveryEntities()
	{
		List<DeliveryEntity> ld1=deliveryservice.getDeliveryEntities();
		ResponseEntity re=new ResponseEntity<List<DeliveryEntity>>(ld1,HttpStatus.OK);
		return re;
	}
	
	/*
	 * @GetMapping(path="/getDeliveryEntityByownerName/{delownerName}") public
	 * ResponseEntity<DeliveryEntity> getDeliveryEntityByownerName(@PathVariable
	 * String ownerName) throws Throwable { DeliveryEntity
	 * d1=deliveryservice.getDeliveryEntityByownerName(ownerName);
	 * 
	 * ResponseEntity re=new ResponseEntity<DeliveryEntity>(d1,HttpStatus.OK);
	 * return re; }
	 */
	
	@PostMapping(path="/addDeliveryEntities")
	public ResponseEntity<List<DeliveryEntity>> addDeliveryEntities(@RequestBody List<DeliveryEntity> ldels)
	{
		List<DeliveryEntity> ldel=deliveryservice.addDeliveryEntities(ldels);
		
		ResponseEntity re=new ResponseEntity<List<DeliveryEntity>>(ldel,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateDeliveryEntity")
	public ResponseEntity<DeliveryEntity> updateDeliveryEntity(@RequestBody DeliveryEntity b) throws Exception
	{
		DeliveryEntity e1=deliveryservice.updateDeliveryEntity(b);
		ResponseEntity re=new ResponseEntity<DeliveryEntity>(e1,HttpStatus.OK);
		return re;
	}
	

	/*
	 * @GetMapping("/getDeliveryEntityBytime/{deltime}") public
	 * ResponseEntity<DeliveryEntity> getDeliveryEntityBytime(@PathVariable String
	 * deltime) { DeliveryEntity c=deliveryservice.getDeliveryEntityBytime(deltime);
	 * ResponseEntity re=new ResponseEntity<DeliveryEntity>(c,HttpStatus.OK); return
	 * re; }
	 */
	
	@GetMapping("/getDeliveryEntityByDate/{date}")
	public ResponseEntity<List<DeliveryEntity>> getDeliveryEntityByDate(@PathVariable String date) 
	{
		List<DeliveryEntity> lc=deliveryservice.getDeliveryEntityByDate(date);
		ResponseEntity re=new ResponseEntity<List<DeliveryEntity>>(lc,HttpStatus.OK);
		return re;
	}
	@GetMapping("/getDeliveryEntityByStatus/{status}")
	public ResponseEntity<List<DeliveryService>> findByStatus(@PathVariable String status) 
	{
		List<DeliveryEntity> lc1=deliveryservice.getDeliveryEntityByStatus(status);
		ResponseEntity re=new ResponseEntity<List<DeliveryEntity>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getDeliveryEntityById/{Id}")
	public ResponseEntity<DeliveryEntity> getDeliveryEntityById(@PathVariable int Id) throws Throwable
	{
		DeliveryEntity d1=deliveryservice.getDeliveryEntityById(Id);
		
		ResponseEntity re=new ResponseEntity<DeliveryEntity>(d1,HttpStatus.OK);
		return re;
	}
	
	
	
	@DeleteMapping(path="/deleteDeliveryEntityById/{Id}")
	public ResponseEntity<DeliveryEntity> deleteDeliveryEntityById(@PathVariable int Id) throws Throwable
	{
		deliveryservice.deleteDeliveryEntityById(Id);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
}
