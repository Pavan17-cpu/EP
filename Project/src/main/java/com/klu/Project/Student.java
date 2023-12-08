package com.klu.Project;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="stu") //to change table name as per requirement
@Entity //equivalent to database tables
public class Student implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id //to represent any column as primary key
int id;
@Column(name="stu_name")
String name;
double cgpa;
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
public double getCgpa() {
	return cgpa;
}
public void setCgpa(double cgpa) {
	this.cgpa = cgpa;
}


	
	

}
