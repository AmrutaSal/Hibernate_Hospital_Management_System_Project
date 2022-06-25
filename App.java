package com.hibernate.jpa.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

public class App {
    public static void main( String[] args )    {
    	EntityManagerFactory emf = null;
    	EntityManager em = null;
    	EntityTransaction etx = null;
    	
    	try {
    		emf = Persistence.createEntityManagerFactory("HibernateDemo");
    		em = emf.createEntityManager();
    		
    		etx = em.getTransaction();
    		etx.begin();
    		
    		Department department = new Department("Gastroenterology");
    		Set<Doctor> doctors = new HashSet<Doctor>();
    		doctors.add(new Doctor("Dr.Govind Verma","gastroenterologist",96573645,"Mumbai", department));
    		doctors.add(new Doctor("Dr.Ravula Phani Kirshna","Liver transplant surgeon",56956563,"Delhi",department));
    		doctors.add(new Doctor("Dr.Dhiraj Agrawal","Endoscopist",355267899,"Benglore",department));
    		
    		Room room =new Room("Phase-1");
    		Patient p1=new Patient("Vihan Chavan",56613662,"Pune",25,"Male",doctors,room);
    		Patient p2=new Patient("Sia Roy",551326536,"Satara",32,"Female",doctors,room);
    		Patient p3=new Patient("Aru Arya",6633455,"Pune",26,"Male",doctors,room);
    		
    		em.persist(p1);
    		em.persist(p2);
    		em.persist(p3);
    		
    		Bill b1 =new Bill(500000,p1);
    		Bill b2 =new Bill(1500000,p2);
    		Bill b3 =new Bill(2500000,p3);
   
    		em.persist(b1);
    		em.persist(b2);
    		em.persist(b3);
    		
    		Receptionist r1=new Receptionist("Sai Joshi",p1);
    		Receptionist r2=new Receptionist("Priya Rai",p2);
    		Receptionist r3=new Receptionist("Shardha Arya",p3);
    		
    		em.persist(r1);
    		em.persist(r2);
    		em.persist(r3);
    	}
    	catch(HibernateException ex) {
    		if(etx != null)
    			etx.rollback();
    		
    		ex.printStackTrace();
    	}
    	finally {
    		if(etx != null)
    			etx.commit();
    		
    		if(em != null)
    			em.close();
    		
    		if(emf != null)
    			emf.close();
    	}
    }
}
