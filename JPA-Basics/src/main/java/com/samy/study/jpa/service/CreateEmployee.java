package com.samy.study.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.samy.study.jpa.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) throws InterruptedException {

		// createEmployee();
		// Employee employee = fetchEmployee(1201);
		// updateEmployee(null);
		// findUpdateEmployee(1201);

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
//		findUpdateEMEmployee(entitymanager, 1201);
		Employee employee = fetchEmployeeEM(entitymanager, 1201);
		updateEmployeeEM(entitymanager, employee);
		entitymanager.close();
		emfactory.close();

	}
	/**
	 * Method Creates an Employee and persists to the Database
	 * 
	 * Creates a EntityManagerFactory
	 * Obtains a Entity Manager from the Created EntityManagerFactory
	 * Begins the transaction
	 * Creates a new Employee objects and sets the details
	 * Persist's the Employee object to the database
	 * Commits the transaction.
	 * 
	 * Begining, Commiting, Closing transaction is required for all DML queries.
	 * Close EntityManager and EntityManagerFactory
	 */
	private static void createEmployee() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Hibernate_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Employee employee = new Employee();
		employee.setEid(1208);
		employee.setEname("Samy");
		employee.setSalary(400000);
		employee.setDeg("Technical Manager");

		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		entitymanager.close();

		System.out.println("Connection Closed..........");
	}

	/**
	 * Method Returns the Employee Object for the given EmployeeId
	 * Creates a EntityManagerFactory
	 * Obtains a Entity Manager from the Created EntityManagerFactory
	 * Begins the transaction
	 * Fetches's the Employee from the database
	 * Commits the transaction.
	 * Close EntityManager and EntityManagerFactory
	 * 
	 * Beginning and Closing Transaction is not required for Read Operations.
	 * @param employeeId
	 * @return Employee
	 */
	private static Employee fetchEmployee(int employeeId) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Hibernate_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Employee employee = entitymanager.find(Employee.class, employeeId);

		entitymanager.getTransaction().commit();
		entitymanager.close();

		System.out.println("Connection Closed fetchEmployee..........");
		return employee;
	}

	/**
	 * Method updates Employee Details
	 * Creates a EntityManagerFactory
	 * Obtains a Entity Manager from the Created EntityManagerFactory
	 * Begins the transaction
	 * Sets updated values to employee records
	 * Merges the record.
	 * Commits the transaction.
	 * Close EntityManager and EntityManagerFactory

	 * @param employee
	 */
	private static void updateEmployee(Employee employee) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Hibernate_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		Employee employees = fetchEmployee(1201);
		entitymanager.getTransaction().begin();
		employees.setSalary(800001);
		entitymanager.merge(employees);
		entitymanager.getTransaction().commit();

		entitymanager.close();

		System.out.println("Connection Closed updateEmployee..........");
	}

	private static Employee fetchEmployeeEM(EntityManager entityManager, int employeeId) {

		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		entityManager.getTransaction().commit();

		System.out.println("Connection Closed fetchEmployee..........");
		return employee;
	}

	private static void updateEmployeeEM(EntityManager entityManager, Employee employee) {

		Employee employees = fetchEmployee(1201);
		entityManager.getTransaction().begin();
		employees.setSalary(800000);
		entityManager.merge(employees);
		entityManager.getTransaction().commit();

		System.out.println("Connection Closed updateEmployee..........");
	}

	private static void findUpdateEmployee(int employeeId) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Hibernate_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		Employee employees = entitymanager.find(Employee.class, employeeId);
		entitymanager.getTransaction().begin();
		employees.setSalary(800000);
		// entitymanager.merge( employees );
		entitymanager.getTransaction().commit();

		entitymanager.close();

		System.out.println("Connection Closed updateEmployee..........");
	}

	private static void findUpdateEMEmployee(EntityManager entityManager, int employeeId) {

		Employee employees = entityManager.find(Employee.class, employeeId);
		entityManager.getTransaction().begin();
		employees.setSalary(800001);
		// entitymanager.merge( employees );
		entityManager.getTransaction().commit();

		System.out.println("Connection Closed updateEmployee..........");
	}
}
