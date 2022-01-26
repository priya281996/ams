package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.DeliveryEntity;
import com.entities.GardShiftEntity;
import com.exception.RecordNotFoundException;
import com.repository.GardShiftDAOInt;
@Service
public class GardShiftService implements GardShiftServiceInt{

	@Autowired
	GardShiftDAOInt gsrepo;
	 
	
	public GardShiftEntity getGardShiftEntityById(String userid) {
		GardShiftEntity d=getGardShiftEntityById(userid);
			return d;
	}

	public List<GardShiftEntity> addGardShiftEntities(List<GardShiftEntity> ls) {
		gsrepo.saveAll(ls);
		return ls;
	}


	public String deleteGardShiftEntity(GardShiftEntity e) {
		gsrepo.delete(e);
		return "Deleted";
		
	}

	public List<GardShiftEntity> getGardShiftEntities() {
		List<GardShiftEntity> d=getGardShiftEntities();
		return d;
	}

	public GardShiftEntity addGardShiftEntity(GardShiftEntity g) {
		gsrepo.save(g);
		return g;
	}

	public String deleteGardShiftEntityById(GardShiftEntity userid) {
		gsrepo.delete(userid);
		return "Deleted";
		
	}

	public String deleteGardShiftEntityById(Integer userid) {
		gsrepo.deleteById(userid);
		return "Deleted";
	}

	public GardShiftEntity getGardShiftEntityById(int id) throws Throwable {
		Supplier s1=()->new RecordNotFoundException("Record for Gard Shift Entity does not exists  in the database ");
		GardShiftEntity be = gsrepo.findById(id).orElseThrow(s1);
		return be;
	}
	
	public GardShiftEntity updateGardShiftEntity(GardShiftEntity gs) throws Throwable {
		int i = gs.getId();
		Supplier s1=()->new RecordNotFoundException("Gard Shift Entity Id does not exists in the database ");
		GardShiftEntity g = gsrepo.findById(i).orElseThrow(s1);
			g.setCreatedBy(gs.getCreatedBy());
			g.setCreatedDateTime(gs.getCreatedDateTime());
			g.setModifiedBy(gs.getModifiedBy());
			g.setModifiedDateTime(gs.getModifiedDateTime());
			g.setUserId(gs.getUserId());
			g.setName(gs.getName());
			g.setDate(gs.getDate());
			g.setTime(gs.getTime());
		return gs;
	}

}
