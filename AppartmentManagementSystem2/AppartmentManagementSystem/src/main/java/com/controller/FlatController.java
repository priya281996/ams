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
import com.entities.FlatEntity;
import com.entities.FlatRentEntity;
import com.repository.FlatDAOInt;
import com.service.FlatRentService;
import com.service.FlatService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin("*")
public class FlatController {

	@Autowired
	FlatService flatservice;
	
	
	@PostMapping("/addFlatEntity")
	public ResponseEntity<FlatEntity> addFlatEntity(@RequestBody FlatEntity flat)
	{
		FlatEntity f1=flatservice.addFlatEntity(flat);
		ResponseEntity re=new ResponseEntity<FlatEntity>(f1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getFlatEntities")
	public ResponseEntity<List<FlatEntity>> getFlatEntities()
	{
		List<FlatEntity> ld1=flatservice.getFlatEntities();
		ResponseEntity re=new ResponseEntity<List<FlatEntity>>(ld1,HttpStatus.OK);
		return re;
	}
	
	/*
	 * @GetMapping(path="/getFlatEntity/{delownerName}") public
	 * ResponseEntity<FlatEntity> getFlatEntityByownerName(@PathVariable FlatEntity
	 * ownerName) throws Throwable { FlatEntity
	 * d1=flatservice.getFlatEntityByownerName(ownerName); ResponseEntity re=new
	 * ResponseEntity<FlatEntity>(d1,HttpStatus.OK); return re; }
	 */
	
	@PostMapping(path="/addFlatEntities")
	public ResponseEntity<List<FlatEntity>> addFlatEntities(@RequestBody List<FlatEntity> ldels)
	{
		List<FlatEntity> ldel=flatservice.addFlatEntities(ldels);
		
		ResponseEntity re=new ResponseEntity<List<FlatEntity>>(ldel,HttpStatus.OK);
		return re;
	}
	
	
	
	@PutMapping(path="/updateFlatEntity")
	public ResponseEntity<FlatEntity> updateFlatEntity(@RequestBody FlatEntity e) throws Throwable
	{
		FlatEntity e1=flatservice.updateFlatEntity(e);
		
		ResponseEntity re=new ResponseEntity<FlatEntity>(e1,HttpStatus.OK);
		return re;
	}
	

	@DeleteMapping(path="/deleteFlatEntityById/{Id}")
	public ResponseEntity<FlatEntity> deleteRentEntityById(@PathVariable int Id) throws Throwable
	{
		flatservice.deleteFlatEntityById(Id);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(path="/getFlatEntityById/{Id}")
	public ResponseEntity<FlatEntity> getFlatEntityById(@PathVariable int Id) throws Throwable
	{
		FlatEntity d1=flatservice.getFlatEntityById(Id);
		
		ResponseEntity re=new ResponseEntity<FlatEntity>(d1,HttpStatus.OK);
		return re;
	}
	
	/*
	 * @DeleteMapping(path="/deleteFlatEntity/{delownerName}") public
	 * ResponseEntity<String> deleteFlatEntityByownerName(@PathVariable String
	 * delownerName) { flatservice.deleteFlatEntityByownerName(delownerName);
	 * 
	 * ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK); return
	 * re; }
	 */
	
	/*
	 * @GetMapping("/getFlatEntityNo/{delflatNo}") public ResponseEntity<FlatEntity>
	 * getFlatEntityBydelflatNo(@PathVariable FlatEntity delflatNo) { FlatEntity
	 * c=flatservice.getFlatEntityBydelflatNo(delflatNo); ResponseEntity re=new
	 * ResponseEntity<FlatEntity>(c,HttpStatus.OK); return re; }
	 * 
	 * @GetMapping("/getFlatEntityNo/{delfloorNo}") public
	 * ResponseEntity<List<FlatEntity>> findByFloor(@PathVariable String delfloorNo)
	 * { List<FlatEntity> lc=flatservice.getFlatEntityBydelfloorNo(delfloorNo);
	 * ResponseEntity re=new ResponseEntity<List<FlatEntity>>(lc,HttpStatus.OK);
	 * return re; }
	 * 
	 * @GetMapping("/getFlatEntitytype/{type}") public
	 * ResponseEntity<List<FlatService>> findType(@PathVariable String type) {
	 * List<FlatEntity> lc1=flatservice.getFlatServiceByType(type); ResponseEntity
	 * re=new ResponseEntity<List<FlatEntity>>(lc1,HttpStatus.OK); return re; }
	 */
	
	//---------------FLATRENTCONTROLLER-------------------------------------
	
	@Autowired
	FlatRentService flatrentservice;

	@PostMapping(path="/addFlatRentEntity")
	public ResponseEntity<FlatRentEntity> addFlatRentEntity(@RequestBody FlatRentEntity flatrent)
	{
		FlatRentEntity d1=flatrentservice.addFlatRentEntity(flatrent);
		ResponseEntity re=new ResponseEntity<FlatRentEntity>(d1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getFlatRentEntities")
	public ResponseEntity<List<FlatRentEntity>> getFlatRentEntities()
	{
		List<FlatRentEntity> ld1=flatrentservice.getFlatRentEntities();
		ResponseEntity re=new ResponseEntity<List<FlatRentEntity>>(ld1,HttpStatus.OK);
		return re;
	}
	
	/*
	 * @GetMapping(path="/getFlatRentEntity/{flatownerName}") public
	 * ResponseEntity<FlatRentEntity> getFlatRentEntityByownerName(@PathVariable
	 * String ownerName) throws Throwable { FlatRentEntity
	 * d1=flatrentservice.getFlatRentEntityByownerName(ownerName);
	 * 
	 * ResponseEntity re=new ResponseEntity<FlatRentEntity>(d1,HttpStatus.OK);
	 * return re; }
	 */
	
	@PostMapping(path="/addFlatRentEntities")
	public ResponseEntity<List<FlatRentEntity>> addFlatRentEntities(@RequestBody List<FlatRentEntity> ldels)
	{
		List<FlatRentEntity> ldel=flatrentservice.addFlatRentEntities(ldels);
		
		ResponseEntity re=new ResponseEntity<List<FlatRentEntity>>(ldel,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateFlatRentEntity")
	public ResponseEntity<FlatRentEntity> updateFlatRentEntity(@RequestBody FlatRentEntity b) throws Throwable
	{
		FlatRentEntity e1=flatrentservice.updateFlatRentEntity(b);
		ResponseEntity re=new ResponseEntity<FlatRentEntity>(e1,HttpStatus.OK);
		return re;
	}
	
	
	@DeleteMapping(path="/deleteFlatRentEntityById/{Id}")
	public ResponseEntity<FlatRentEntity> deleteFlatRentEntityById(@PathVariable int Id) throws Throwable
	{
		flatrentservice.deleteFlatRentEntityById(Id);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(path="/getFlatRentEntityById/{Id}")
	public ResponseEntity<FlatRentEntity> getFlatRentEntityById(@PathVariable int Id) throws Throwable
	{
		FlatRentEntity d1=flatrentservice.getFlatRentEntityById(Id);
		
		ResponseEntity re=new ResponseEntity<FlatRentEntity>(d1,HttpStatus.OK);
		return re;
	}
	
	/*
	 * @GetMapping("/getFlatRentEntitytype/{type}") public
	 * ResponseEntity<FlatRentEntity> getDeliveryEntityBytime(@PathVariable String
	 * type) { FlatRentEntity c=flatrentservice.getFlatRentEntityBytime(type);
	 * ResponseEntity re=new ResponseEntity<FlatRentEntity>(c,HttpStatus.OK); return
	 * re; }
	 */
	
	/*
	 * @GetMapping("/getFlatRentEntityamount/{amount}") public
	 * ResponseEntity<List<FlatRentEntity>> getFlatRentEntityByAmount(@PathVariable
	 * String amount) { List<FlatRentEntity>
	 * lc=flatrentservice.getFlatRentEntityByAmount(amount); ResponseEntity re=new
	 * ResponseEntity<List<FlatRentEntity>>(lc,HttpStatus.OK); return re; }
	 * 
	 * @GetMapping("/getFlatRentEntityfno/{flatNo}") public
	 * ResponseEntity<List<FlatRentEntity>> getFlatRentEntityByFlatNo(@PathVariable
	 * String flatNo) { List<FlatRentEntity>
	 * lc1=flatrentservice.getFlatRentEntityByFlatNo(flatNo); ResponseEntity re=new
	 * ResponseEntity<List<FlatRentEntity>>(lc1,HttpStatus.OK); return re; }
	 */
		
}
