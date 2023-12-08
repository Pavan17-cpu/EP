package com.klu.Project;

import javax.ejb.Remote;

@Remote
public interface EJBInterface {
public String insertStudent(Student s);
public String deleteStudent(int id);
public String updateStudent(Student s);

}
