package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.DeliveryEntity;
import com.entities.FlatEntity;
import com.entities.FlatRentEntity;
import com.exception.RecordNotFoundException;
import com.repository.FlatRentDAO;



@Service
public class FlatRentService implements FlatRentServiceInt{
	
	@Autowired
	FlatRentDAO flatrentrepo;

	public FlatRentEntity add(FlatRentEntity c) {
		flatrentrepo.save(c);
		return c;
	}

	public FlatRentEntity addFlatRentEntity(FlatRentEntity del) {
		flatrentrepo.save(del);
		return del;
	}

	public List<FlatRentEntity> getFlatRentEntities() {
		List<FlatRentEntity> ls = flatrentrepo.findAll();
		return ls;
	}

	/*
	 * public FlatRentEntity getFlatRentEntityByownerName(String ownerName) {
	 * FlatRentEntity d=getFlatRentEntityByownerName(ownerName); return d; }
	 */
	public List<FlatRentEntity> addFlatRentEntities(List<FlatRentEntity> ldels) {
		flatrentrepo.saveAll(ldels);
		return ldels;
	}


	public String deleteFlatRentEntityById(int d) {
		flatrentrepo.deleteById(d);
		return "Deleted";
		
	}
	
	public FlatRentEntity getFlatRentEntityById(int id) throws Throwable {
		Supplier s1=()->new RecordNotFoundException("Record for FlatRent Entity does not exists  in the database ");
		FlatRentEntity fr = flatrentrepo.findById(id).orElseThrow(s1);
		return fr;
	}
	
	public FlatRentEntity updateFlatRentEntity(FlatRentEntity fr) throws Throwable {
		int i = fr.getId();
		Supplier s1=()->new RecordNotFoundException("FlatRent Entity Id does not exists in the database ");
		FlatRentEntity f = flatrentrepo.findById(i).orElseThrow(s1);
			f.setCreatedBy(fr.getCreatedBy());
			f.setCreatedDateTime(fr.getCreatedDateTime());
			f.setModifiedBy(fr.getModifiedBy());
			f.setModifiedDateTime(fr.getModifiedDateTime());
			f.setOwnerName(fr.getOwnerName());
			f.setAmount(fr.getAmount());
			f.setFlatNo(fr.getFlatNo());
			f.setType(fr.getType());
		return f;
	}
	
	
	/*
	 * public FlatRentEntity getFlatRentEntityBytime(String type) { FlatRentEntity
	 * d=getFlatRentEntityByownerName(type); return d; }
	 */

	/*
	 * public List<FlatRentEntity> getFlatRentEntityByAmount(List<FlatRentEntity>
	 * amount) { flatrentrepo.saveAll(amount); return amount; }
	 * 
	 * public List<FlatRentEntity> getFlatRentEntityByFlatNo(List<FlatRentEntity>
	 * flatNo) { flatrentrepo.saveAll(flatNo); return flatNo; }
	 */

}
