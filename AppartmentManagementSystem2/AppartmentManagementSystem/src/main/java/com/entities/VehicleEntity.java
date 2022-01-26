package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class VehicleEntity extends BaseEntity {

	@NotBlank
	private String name;
	@NotBlank
	private String parkingNo;
	private String arrivalTime;
	private String departureTime;
	private String date;
	@NotBlank
	private String vehicleNo;
	@NotBlank
	private String vehicleType;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParkingNo() {
		return parkingNo;
	}

	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String toString() {
		return "VehicleEntity [name=" + name + ", parkingNo=" + parkingNo + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", date=" + date + ", vehicleNo=" + vehicleNo + ", vehicleType="
				+ vehicleType + "]";
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