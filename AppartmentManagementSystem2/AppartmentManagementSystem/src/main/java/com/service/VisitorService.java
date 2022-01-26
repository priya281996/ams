package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.DeliveryEntity;
import com.entities.VehicleEntity;
import com.entities.VisitorEntity;
import com.exception.RecordNotFoundException;
import com.repository.VisitorDAOInt;

@Service
public class VisitorService implements VisitorServiceInt{

	@Autowired
	VisitorDAOInt vdrepo;

	public VisitorEntity addVisitorEntity(VisitorEntity v) {
		vdrepo.save(v);
		return v;
	}

	public List<VisitorEntity> addVisitorEntities(List<VisitorEntity> ls) {
		List<VisitorEntity> v1 = vdrepo.findAll();
		return v1;
	}

	public List<VisitorEntity> getVisitorEntities() {
		List<VisitorEntity> lv1 = vdrepo.findAll();
		return lv1;
	}

	public String deleteVisitorEntityById(int id) {
		vdrepo.deleteById(id);
		return "Deleted";		
	}

	
	
	public VisitorEntity getVisitorEntityById(int id) throws Throwable {
		Supplier s1=()->new RecordNotFoundException("Record for Visitor Entity does not exists  in the database ");
		VisitorEntity vd = vdrepo.findById(id).orElseThrow(s1);
		return vd;
	}
	
	public VisitorEntity updateVisitorEntity(VisitorEntity vd) throws Exception {
		int i = vd.getId();
		Supplier <Exception>s1=()->new RecordNotFoundException("Visitor Entity Id does not exists in the database ");
		VisitorEntity vr = vdrepo.findById(i).orElseThrow(s1);
			vr.setCreatedBy(vd.getCreatedBy());
			vr.setCreatedDateTime(vd.getCreatedDateTime());
			vr.setModifiedBy(vd.getModifiedBy());
			vr.setModifiedDateTime(vd.getModifiedDateTime());
			vr.setName(vd.getName());
			vr.setOwnerName(vd.getOwnerName());
			vr.setFlatNo(vd.getFlatNo());
			vr.setDate(vd.getDate());
			vr.setArrivalTime(vd.getArrivalTime());
			vr.setDepartureTime(vd.getDepartureTime());
			
		return vd;
	}

	
//	public void deleteVisitor(VisitorEntity e) {
	//	// TODO Auto-generated method stub
		
	//}

	
}
