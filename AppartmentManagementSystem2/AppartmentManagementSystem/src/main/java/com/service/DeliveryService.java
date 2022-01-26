package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.BaseEntity;
import com.entities.DeliveryEntity;
import com.exception.RecordNotFoundException;
import com.repository.DeliveryDAOInt;
@Service
public class DeliveryService implements DeliveryServiceInt {

	@Autowired
	DeliveryDAOInt delrepo;

	public DeliveryEntity addDeliveryEntity(DeliveryEntity del) {
		delrepo.save(del);
		return del;
	}

	public List<DeliveryEntity> getDeliveryEntities() {
		List<DeliveryEntity> ls = delrepo.findAll();
		return ls;
	}


	/*
	 * public DeliveryEntity getDeliveryEntityByownerName(String ownerName) {
	 * DeliveryEntity d=getDeliveryEntityByownerName(ownerName); return d; }
	 */

	public List<DeliveryEntity> addDeliveryEntities(List<DeliveryEntity> ldels) {
		delrepo.saveAll(ldels);
		return ldels;
	}
	/*
	 * public DeliveryEntity getDeliveryEntityBytime(String deltime) {
	 * DeliveryEntity d1=getDeliveryEntityBytime(deltime); return d1; }
	 */

	public List<DeliveryEntity> getDeliveryEntityByDate(String date) {
		List<DeliveryEntity> date1 = delrepo.findAll();
		return date1;
		
	}

	public List<DeliveryEntity> getDeliveryEntityByStatus(String status) {
		List<DeliveryEntity> status1 = delrepo.findAll();
		return status1;
	}

	public String deleteDeliveryEntityById(int id) {
		delrepo.deleteById(id);
		return "Deleted";
	}
		
	public DeliveryEntity getDeliveryEntityById(int id) throws Throwable {
		Supplier s1=()->new RecordNotFoundException("Record for Delivery Entity does not exists  in the database ");
		DeliveryEntity be = delrepo.findById(id).orElseThrow(s1);
		return be;
	}
	
	public DeliveryEntity updateDeliveryEntity(DeliveryEntity de) throws Exception {
		int i = de.getId();
		Supplier<Exception>s1=()->new RecordNotFoundException("Delivery Entity Id does not exists in the database ");
		DeliveryEntity d = delrepo.findById(i).orElseThrow(s1);
		d.setCreatedBy(de.getCreatedBy());
		d.setCreatedDateTime(de.getCreatedDateTime());
		d.setModifiedBy(de.getModifiedBy());
		d.setModifiedDateTime(de.getModifiedDateTime());
			d.setOwnerName(de.getOwnerName());
			d.setDate(de.getDate());
			d.setStatus(de.getStatus());
			d.setTime(de.getTime());
		return de;
	}

	
	
	}