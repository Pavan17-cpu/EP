package com.klu.Project;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.ejb.EJB;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.faces.bean.ManagedBean;
import javax.net.ssl.HttpsURLConnection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@ManagedBean(name="obj",eager=true)

public class Service {
	
int id;
String name;
double cgpa;
String r;


public String getR() {
	return r;
}
public void setR(String r) {
	this.r = r;
}
@EJB(lookup="java:global/Project/EJBClass!com.klu.Project.EJBInterface")
EJBInterface obj;
	

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

public void save()
{

	Student s=new Student();
	s.setId(id);
	s.setName(name);
	s.setCgpa(cgpa);
	System.out.println(obj.insertStudent(s));
}
public void triggerPost() {
    try {
      URL url=new URL("http://localhost:8080/Project/abc/f1");
      HttpURLConnection con=(HttpURLConnection) url.openConnection();
      con.setRequestMethod("POST");
      con.setRequestProperty("Accept","application/json" );
      
      BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
      name=br.readLine();
      
    } 
    catch (Exception e) {
      name=e.getMessage();
      e.printStackTrace();
    }
}
public void delete()
{
	 r =obj.deleteStudent(id);
	System.out.println(r);
}
public void update() {
    Student s = new Student();
    s.setId(id);
    s.setName(name);
    s.setCgpa(cgpa);
    System.out.println(obj.updateStudent(s));
}


}
