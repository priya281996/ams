package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
@Entity
public class GardSalaryEntity extends BaseEntity {

	@NotBlank
	private String name;
	@NotBlank
	private String userId;
	@NotEmpty
	private long amount;
	private String status;
	private String date;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	@Override
	public String toString() {
		return "GardSalaryEntity [name=" + name + ", userId=" + userId + ", amount=" + amount + ", status=" + status
				+ ", date=" + date + "]";
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
