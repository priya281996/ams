package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.GardSalaryEntity;
import com.entities.GardShiftEntity;
import com.service.GardSalaryService;
import com.service.GardShiftService;

@RestController
@RequestMapping(path="/api")
public class GardContoller {
	

	@Autowired
	GardShiftService gardshiftservice;
	
	@PostMapping("/addGardShiftEntity")
	public ResponseEntity<GardShiftEntity> addGardShiftEntity(@RequestBody GardShiftEntity g)
	{
		GardShiftEntity g1=gardshiftservice.addGardShiftEntity(g);
		ResponseEntity re=new ResponseEntity<GardShiftEntity>(g1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getGardShiftEntities")
	public ResponseEntity<List<GardShiftEntity>> getGardShiftEntities()
	{
		List<GardShiftEntity> lg1=gardshiftservice.getGardShiftEntities();
		ResponseEntity re=new ResponseEntity<List<GardShiftEntity>>(lg1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getGardShiftEntityById/{userId}")
	public ResponseEntity<GardShiftEntity> getGardShiftEntityById(@PathVariable String userid) throws Throwable
	{
		GardShiftEntity g1=gardshiftservice.getGardShiftEntityById(userid);
		
		ResponseEntity re=new ResponseEntity<GardShiftEntity>(g1,HttpStatus.OK);
		return re;
	}

	
	@PostMapping(path="/addGardShiftEntities")
	public ResponseEntity<List<GardShiftEntity>> addGardShiftEntities(@RequestBody List<GardShiftEntity> ls)
	{
		List<GardShiftEntity> le=gardshiftservice.addGardShiftEntities(ls);
		
		ResponseEntity re=new ResponseEntity<List<GardShiftEntity>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateGardShiftEntity")
	public ResponseEntity<GardSalaryEntity> updateGardShiftEntity(@RequestBody GardShiftEntity e) throws Throwable
	{
		GardShiftEntity e1=gardshiftservice.updateGardShiftEntity(e);
		
		ResponseEntity re=new ResponseEntity<>(e1,HttpStatus.OK);
		return re;
	}
	

	
	@DeleteMapping(path="/deleteGardShiftEntityById/{userId}")
	public ResponseEntity<String> deleteGardShiftEntityById(@PathVariable int userid)
	{
		gardshiftservice.deleteGardShiftEntityById(userid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	



	
	//---------------GARDSALARYCONTROLLER-------------------------------------
	
	
	  
	  
	  @Autowired GardSalaryService gardsalaryservice;
	  
	  @PostMapping("/addGardSalaryEntity") 
	  public ResponseEntity<GardSalaryEntity>
	  addGardSalaryEntity(@RequestBody GardSalaryEntity g) 
	  {
		  GardSalaryEntity  g1=gardsalaryservice.addGardSalaryEntity(g);
	  ResponseEntity re=new ResponseEntity<GardSalaryEntity>(g1,HttpStatus.OK); 
	  return re;
	  }
	  
	  @GetMapping("/getGardSalaryEntities")
	  public ResponseEntity<List<GardSalaryEntity>> getGardSalaryEntities() {
	  List<GardSalaryEntity> lg1=gardsalaryservice.getGardSalaryEntities();
	  ResponseEntity re=new
	  ResponseEntity<List<GardSalaryEntity>>(lg1,HttpStatus.OK);
	  return re; 
	  }
	  
	  @GetMapping(path="/getGardSalaryEntityById/{userId}")
		public ResponseEntity<GardShiftEntity> getGardSalaryEntityById(@PathVariable int userid) throws Throwable
		{
			GardSalaryEntity g1=gardsalaryservice.getGardSalaryEntityById(userid);
			
			ResponseEntity re=new ResponseEntity<GardSalaryEntity>(g1,HttpStatus.OK);
			return re;
		}
	  
		/*
		 * @GetMapping(path="/getGardSalaryEntityByname/{name}") public
		 * ResponseEntity<GardSalaryEntity> getGardSalaryEntityByName(@PathVariable
		 * String name) throws Throwable { GardSalaryEntity
		 * g1=gardsalaryservice.getGardSalaryEntityByName(name); ResponseEntity re=new
		 * ResponseEntity<GardSalaryEntity>(g1,HttpStatus.OK); return re; }
		 */
	  
	  @PostMapping(path="/addGardSalaryEntities") 
	  public  ResponseEntity<List<GardSalaryEntity>> addGardSalaryEntities(@RequestBody List<GardSalaryEntity> ls) { 
	  List<GardSalaryEntity> le=gardsalaryservice.addGardSalaryEntities(ls);
	  
	  ResponseEntity re=new  ResponseEntity<List<GardSalaryEntity>>(le,HttpStatus.OK); 
	  return re; 
	  }
	  
	  @PutMapping(path="/updateGardSalaryEntity") public
	  ResponseEntity<GardSalaryEntity> updateGardSalaryEntity(@RequestBody
	  GardSalaryEntity e) throws Throwable { GardSalaryEntity
	  e1=gardsalaryservice.updateGardSalaryEntity(e);
	  
	  ResponseEntity re=new ResponseEntity<GardSalaryEntity>(e1,HttpStatus.OK);
	  return re; }
	  
	 
	  
	  @DeleteMapping(path="/deleteGardSalaryEntityById/{userid}") public
	  ResponseEntity<String> deleteGardSalaryEntityByUserId(@PathVariable int
	  userid) { gardsalaryservice.deleteGardSalaryEntityByUserId(userid);
	  
	  ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK); return
	  re; 
	  }
	  
	 
	  
}
	 
