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

import com.entities.UserEntity;
import com.service.UserService;



@RestController
@RequestMapping(path="/api")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userservice;
	
	
	@PostMapping("/addUser")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity c)
	{
		UserEntity c1=userservice.addUser(c);
		ResponseEntity re=new ResponseEntity<UserEntity>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<UserEntity>> getUsers()
	{
		List<UserEntity> lc1=userservice.getUser();
		ResponseEntity re=new ResponseEntity<List<UserEntity>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getUser/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable int id) throws Throwable
	{
		UserEntity c1=userservice.getUserEntityById(id);
		
		ResponseEntity re=new ResponseEntity<UserEntity>(c1,HttpStatus.OK);
		return re;
	}

	
	@PostMapping(path="/addUsers")
	public ResponseEntity<List<UserEntity>> addUsers(@RequestBody List<UserEntity> ls)
	{
		List<UserEntity> le=userservice.addUsers(ls);
		
		ResponseEntity re=new ResponseEntity<List<UserEntity>>(le,HttpStatus.OK);
		return re;
	}
	
	
	@PutMapping(path="/updateUser")
	public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity e) throws Throwable
	{
		UserEntity e1=userservice.updateUser(e);
		
		ResponseEntity re=new ResponseEntity<UserEntity>(e1,HttpStatus.OK);
		return re;
	}
	
	
	
	@DeleteMapping(path="/deleteUserById/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int id)
	{
		userservice.deleteUserEntityById(id);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	

}
