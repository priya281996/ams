package com.service;

import java.util.ArrayList;


import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.entities.VehicleEntity;
import com.exception.RecordNotFoundException;
import com.repository.VehicleDAOInt;

@Service
public class VehicleService implements VehicleServiceInt{

	@Autowired
	VehicleDAOInt vrepo;
	
	List<VehicleEntity> le;
	
	public VehicleEntity addVehicleEntity(VehicleEntity ve)
	{
		VehicleEntity v1=vrepo.save(ve);
		return v1;
	}
	
	public List<VehicleEntity> getVehicleEntities()
	{
		le=new ArrayList<>();
		le=vrepo.findAll();
		return le;
	}
	
	public String deleteVehicle(VehicleEntity e) {
		vrepo.delete(e);
		return "Deleted";
	}

	
	public String deleteVehicleEntityById(int id) {
		vrepo.deleteById(id);
		return "Deleted";
	}
	
	
	public List<VehicleEntity> addVehicleEntities(List<VehicleEntity> v) {
		le=new ArrayList<>();
		le=vrepo.saveAll(v);
		return le;
	}
	
	public VehicleEntity getVehicleEntityById(int id) throws Exception {
		Supplier<Exception> s1=()->new RecordNotFoundException("Record for Vehicle Entity does not exists  in the database ");
		VehicleEntity ve = vrepo.findById(id).orElseThrow(s1);
		return ve;
	}
	
	public VehicleEntity updateVehicleEntity(VehicleEntity ve) throws Exception {
		int i = ve.getId();
		Supplier<Exception> s1=()->new RecordNotFoundException("Vehicle Entity Id does not exists in the database ");
		VehicleEntity v = vrepo.findById(i).orElseThrow(s1);
			v.setCreatedBy(ve.getCreatedBy());
			v.setCreatedDateTime(ve.getCreatedDateTime());
			v.setModifiedBy(ve.getModifiedBy());
			v.setModifiedDateTime(ve.getModifiedDateTime());
			v.setName(ve.getName());
			v.setParkingNo(ve.getParkingNo());
			v.setArrivalTime(ve.getArrivalTime());
			v.setDepartureTime(ve.getDepartureTime());
			v.setDate(ve.getDate());
			v.setVehicleNo(ve.getVehicleNo());
			v.setVehicleType(ve.getVehicleType());
			vrepo.save(v);
		    return v;
	}

	

	
	
}
