package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class VisitorEntity extends BaseEntity {
     @GeneratedValue
	private String name;
	
	private String ownerName;
	
	private String flatNo;
	private String date;
	private String arrivalTime;
	private String departureTime;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "VisitorEntity [name=" + name + ", ownerName=" + ownerName + ", flatNo=" + flatNo + ", date=" + date
				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
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
