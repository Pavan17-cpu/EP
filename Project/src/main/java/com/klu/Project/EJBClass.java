package com.klu.Project;

import javax.ejb.Stateless;
import com.klu.Project.Service;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EJBClass implements EJBInterface{

	EntityManagerFactory emf = new Persistence().createEntityManagerFactory("jpa");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public String insertStudent(Student s) {
		try {
		
			EntityManagerFactory emf = new Persistence().createEntityManagerFactory("jpa");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			em.close();
			emf.close();
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				
			}
		return "Insert success";
	}

	@Override
	public String deleteStudent(int id) {
		try {
			Student s=	em.find(Student.class, id);
			em.getTransaction().begin();
			em.remove(s);
			em.getTransaction().commit();
			em.close();
			emf.close();
		}catch(Exception e )
		{
			e.printStackTrace();
		}
		return "delete success";
		
	}
	  @Override
	  public String updateStudent(Student s) {
	        try {
	            em.getTransaction().begin();
	            em.merge(s);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Update failed";
	        } finally {
	            em.close();
	            emf.close();
	        }
	        return "Update success";
	    }

	

}
