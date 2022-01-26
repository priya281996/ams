package com.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Entity
public class FlatRentEntity extends BaseEntity{
	@NotEmpty
	private String ownerName;
	@NotBlank
	private String flatNo;
	@NotBlank
	private String amount;
	@NotBlank
	private String type;
	
	
	
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	@Override
	public String toString() {
		return "FlatRentEntity [ownerName=" + ownerName + ", flatNo=" + flatNo + ", amount=" + amount + ", type=" + type
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

	public FlatRentEntity orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
