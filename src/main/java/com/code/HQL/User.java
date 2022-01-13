package com.code.HQL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity()
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	//@Temporal(TemporalType.DATE)
	private Date date;
	/*@OneToOne
	@JoinColumn(name="vehicleId")
	private Vehicle vehicle;
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}*/
	//@OneToMany
	//@JoinTable(name="user_vehicle_table", joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="vehicleId"))
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
