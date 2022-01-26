package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.RecordNotFoundException;
import com.entities.DeliveryEntity;
import com.entities.GardSalaryEntity;

import com.repository.GardSalaryDAOInt;
@Service
public class GardSalaryService  implements GardSalaryServiceInt{

	@Autowired
	GardSalaryDAOInt grepo;
	
	
	public GardSalaryEntity addGardSalaryEntity(GardSalaryEntity g) {
		grepo.save(g);
		return g;
	}

	public List<GardSalaryEntity> getGardSalaryEntities() {
		List<GardSalaryEntity> ls = grepo.findAll();
		return ls;
	}

	public GardSalaryEntity getGardSalaryEntityByName(String name) {
		GardSalaryEntity d=getGardSalaryEntityByName(name);
		return d;
	}

	public List<GardSalaryEntity> addGardSalaryEntities(List<GardSalaryEntity> ldels) {
		grepo.saveAll(ldels);
		return ldels;
	}

	
	public int deleteGardSalaryEntityByUserId(int userid) {
		grepo.deleteById(userid);
		return userid;
		
	}

	

	

	public GardSalaryEntity getGardSalaryEntityById(int id) throws Throwable {
		Supplier s1=()->new RecordNotFoundException("Record for Gard Salary Entity does not exists  in the database ");
		GardSalaryEntity ge = grepo.findById(id).orElseThrow(s1);
		return ge;
	}
	
	public GardSalaryEntity updateGardSalaryEntity(GardSalaryEntity ge) throws Throwable {
		int i = ge.getId();
		Supplier s1=()->new RecordNotFoundException("Gard Salary Entity Id does not exists in the database ");
		GardSalaryEntity g = grepo.findById(i).orElseThrow(s1);
			g.setCreatedBy(ge.getCreatedBy());
			g.setCreatedDateTime(ge.getCreatedDateTime());
			g.setModifiedBy(ge.getModifiedBy());
			g.setModifiedDateTime(ge.getModifiedDateTime());
			g.setName(ge.getName());
			g.setUserId(ge.getUserId());
			g.setAmount(ge.getAmount());
			g.setDate(ge.getDate());
			g.setStatus(ge.getStatus());
		return ge;
	}

}
