package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.DeliveryEntity;
import com.entities.FlatEntity;
import com.exception.RecordNotFoundException;
import com.repository.FlatDAOInt;
@Service
public class FlatService implements FlatServiceInt{
	
	@Autowired
	FlatDAOInt flatrepo;

	public FlatEntity addFlatEntity(FlatEntity flat) {
		flatrepo.save(flat);
		return flat;
	}
	
	public List<FlatEntity> getFlatEntities() {
		List<FlatEntity> ls = flatrepo.findAll();
		return ls;
	}

	public FlatEntity getFlatEntityByownerName(FlatEntity ownerName) {
		FlatEntity d=getFlatEntityByownerName(ownerName);
		return d;
	}

	public List<FlatEntity> addFlatEntities(List<FlatEntity> ldels) {
		flatrepo.saveAll(ldels);
		return ldels;
	}

	public String deleteFlatEntityById(int d) {
		flatrepo.deleteById(d);
		return "Deleted";
		
	}

		/*
		 * public FlatEntity deleteFlatEntityByownerName(String delownerName) {
		 * FlatEntity d=deleteFlatEntityByownerName(delownerName); return d; }
		 * 
		 * public FlatEntity getFlatEntityBydelflatNo(FlatEntity delflatNo) { FlatEntity
		 * d1=getFlatEntityBydelflatNo(delflatNo); return d1; }
		 * 
		 * public List<FlatEntity> getFlatEntityByType(String type) { List<FlatEntity>
		 * type1 = flatrepo.findAll(); return type1; }
		 * 
		 * public List<FlatEntity> getFlatEntityBydelfloorNo(String delfloorNo) {
		 * List<FlatEntity> d1=getFlatEntityBydelfloorNo(delfloorNo); return d1; }
		 */
	public FlatEntity getFlatEntityById(int id) throws Throwable {
		Supplier s1=()->new RecordNotFoundException("Record for Flat Entity does not exists  in the database ");
		FlatEntity fe = flatrepo.findById(id).orElseThrow(s1);
		return fe;
	}
	
	public FlatEntity updateFlatEntity(FlatEntity fe) throws Throwable {
		int i = fe.getId();
		Supplier s1=()->new RecordNotFoundException("Flat Entity Id does not exists in the database ");
		FlatEntity f = flatrepo.findById(i).orElseThrow(s1);
			f.setCreatedBy(fe.getCreatedBy());
			f.setCreatedDateTime(fe.getCreatedDateTime());
			f.setModifiedBy(fe.getModifiedBy());
			f.setModifiedDateTime(fe.getModifiedDateTime());
			f.setOwnerName(fe.getOwnerName());
			f.setFlatNo(fe.getFlatNo());
			f.setFloorNo(fe.getFloorNo());
			f.setFlatType(fe.getFlatType());
		   return f;
	}

}
