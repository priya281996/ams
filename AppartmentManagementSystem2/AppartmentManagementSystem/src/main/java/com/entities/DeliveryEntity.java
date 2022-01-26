package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
public class DeliveryEntity extends BaseEntity {
//   @Size(min=2)
//   @NotEmpty
	private String ownerName;
	private String time;
	private String date;
	private String status;
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "DeliveryEntity [ownerName=" + ownerName + ", time=" + time + ", date=" + date + ", status=" + status
				+ "]";
	}

	@Override
	
	public String getKey() {
		
		String createdKey ="Key is created" ;
		return createdKey;
	}
	@Override
	public String getValue() {
		
		String createdValue = "Value is created";
		return createdValue;
	}

}
