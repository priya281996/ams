package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.BaseEntity;
import com.entities.DeliveryEntity;
import com.exception.RecordNotFoundException;
import com.repository.BaseDAOInt;

@Service
public class BaseService {

	@Autowired
	BaseDAOInt baserepo;
	public BaseEntity addBaseEntity(BaseEntity b) {
		baserepo.save(b);
		return b;
	}
	

	public List<BaseEntity> getBaseEntities() {
		List<BaseEntity> ls = baserepo.findAll();
		return ls;
	}

	public List<BaseEntity> addBaseEntities(List<BaseEntity> ldels) {
	baserepo.saveAll(ldels);
		return ldels;
	}
	

	public String deleteBaseEntityById(int Id) {
		baserepo.deleteById(Id);
		return "Deleted";
	}
	
	
	public BaseEntity getBaseEntityById(int id) throws Throwable {
		Supplier s1=()->new RecordNotFoundException("Record does not exists for Base Entity in the database ");
		BaseEntity be = baserepo.findById(id).orElseThrow(s1);
		return be;
	}
	
	public BaseEntity updateBaseEntity(BaseEntity be) throws Throwable {
		int i = be.getId();
		Supplier s1=()->new RecordNotFoundException("Base Entity Id does not exists in the database ");
		BaseEntity b = baserepo.findById(i).orElseThrow(s1);
			b.setCreatedBy(be.getCreatedBy());
			b.setCreatedDateTime(be.getCreatedDateTime());
			b.setModifiedBy(be.getModifiedBy());
			b.setModifiedDateTime(be.getModifiedDateTime());
		return be;
	}

	
}
