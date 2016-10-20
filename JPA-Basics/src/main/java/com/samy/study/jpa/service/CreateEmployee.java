package com.samy.study.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.samy.study.jpa.entity.Employee;

public class CreateEmployee {
	
	 public static void main( String[ ] args ) throws InterruptedException {
		   
	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Hibernate_JPA" );
	      
	      EntityManager entitymanager = emfactory.createEntityManager( );
	      entitymanager.getTransaction( ).begin( );

	      Employee employee = new Employee( ); 
	      employee.setEid( 1208 );
	      employee.setEname( "Samy" );
	      employee.setSalary( 400000 );
	      employee.setDeg( "Technical Manager" );
	      
	      entitymanager.persist( employee );
	      entitymanager.getTransaction( ).commit( );
	      entitymanager.close( );	      
	      emfactory.close( );
	   }

}
