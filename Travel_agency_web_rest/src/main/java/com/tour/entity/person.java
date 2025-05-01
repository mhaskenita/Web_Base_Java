package com.tour.entity;

import java.util.List;

import org.hibernate.annotations.GeneratorType;

import com.tour.controller.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class person 
{@Id
@GeneratedValue

@Column(length =40)
private String name;
@Column(length =40)
private String duration;
@Column(length =40)
private Double Price;
private String transportationtype;

public person()
{
	
	
}
public person(String name, String duration, Double price, String transportationtype) {
	super();
	this.name = name;
	this.duration = duration;
	Price = price;
	this.transportationtype = transportationtype;
}

public String getName() {
	return name;
	
}

public void setName(String name) {
	this.name = name;
}

public String getDuration() {
	return duration;
}

public void setDuration(String duration) {
	this.duration = duration;
}

public Double getPrice() {
	return Price;
}

public void setPrice(Double price) {
	Price = price;
}

public String getTransportationtype() {
	return transportationtype;
}

public void setTransportationtype(String transportationtype) {
	this.transportationtype = transportationtype;
}

@Override
public String toString() {
	return "person [name=" + name + ", duration=" + duration + ", Price=" + Price + ", transportationtype="
			+ transportationtype + "]";
}



public static void save(person newperson) {
	
	
}
public static List<person> findAll() {
	
	return null;
}

}
