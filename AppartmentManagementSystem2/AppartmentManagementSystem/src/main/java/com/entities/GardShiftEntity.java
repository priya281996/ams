package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class GardShiftEntity extends BaseEntity {
	@NotBlank
	private long userId;
	@NotBlank
	private String name;
	
	private String time;
	private String date;
	
	
	public long getUserId() {
		return  userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	
	@Override
	public String toString() {
		return "GardShiftEntity [userId=" + userId + ", name=" + name + ", time=" + time + ", date=" + date + "]";
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}

