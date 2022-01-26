package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.UserEntity;
import com.exception.RecordNotFoundException;
import com.repository.UserDAOInt;


@Service
public class UserService implements UserServiceInt{
	
	@Autowired
	UserDAOInt userrepo;
	
	public UserEntity addUser(UserEntity c)
	{
		UserEntity c1=userrepo.save(c);
		return c1;
	}
	
	public List<UserEntity> getUser()
	{
		List<UserEntity> ls=userrepo.findAll();
		return ls;
	}
	
	public UserEntity getUserEntityById(int id) throws Throwable {
		Supplier s1=()->new RecordNotFoundException("Record does not exists for User Entity in the database");
		UserEntity c=userrepo.findById(id).orElseThrow(null);
		return c;
	}
	
    public String deleteUserEntityById(int id) {
		
		userrepo.deleteById(id);
		return "Deleted";
	}
   
   public UserEntity updateUser(UserEntity c) throws Exception {
		 int id=c.getId();
		Supplier<Exception> s1= ()->new RecordNotFoundException("Coder Id Does not exist in the database");
		UserEntity c1=userrepo.findById(id).orElseThrow(null);
		c1.setCreatedBy(c.getCreatedBy());
		c1.setCreatedDateTime(c.getCreatedDateTime());
		c1.setModifiedBy(c1.getModifiedBy());
		c1.setModifiedDateTime(c1.getModifiedDateTime());
		
		
		    c1.setFirstName(c.getFirstName());
			c1.setLastName(c.getLastName());
			c1.setLoginId(c.getLoginId());
			c1.setPassword(c.getPassword());
			c1.setMobileNo(c.getMobileNo());
			c1.setEmailId(c.getEmailId());
			c1.setRoleId(c.getRoleId());
			userrepo.save(c1);
			return c1;	
	}

	public List<UserEntity> addUsers(List<UserEntity> ls) 
	{
		userrepo.saveAll(ls);
		return ls;
	}

	

}
