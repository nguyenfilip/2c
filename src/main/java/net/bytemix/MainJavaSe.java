package net.bytemix;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.bytemix.entity.Employee;

public class MainJavaSe {
	private static EntityManagerFactory emf;

	public static void main(String[] args) throws SQLException {

		emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Employee p = new Employee();
		em.persist(p);
		em.getTransaction().commit();
		
		System.out.println(em.find(Employee.class, p.getId()));
		
		em.close();
		emf.close();
	}


}
