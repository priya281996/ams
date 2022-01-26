package com.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class FlatEntity extends BaseEntity {

	@Size(min=2)
	@NotEmpty
	private String ownerName;
	@NotBlank
	private String flatNo;
	@NotBlank
	private String floorNo;
	@NotEmpty
	private String flatType;
	
	
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

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public String getFlatType() {
		return flatType;
	}

	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}

	@Override
	public String toString() {
		return "FlatEntity [ownerName=" + ownerName + ", flatNo=" + flatNo + ", floorNo=" + floorNo + ", flatType="
				+ flatType + "]";
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
