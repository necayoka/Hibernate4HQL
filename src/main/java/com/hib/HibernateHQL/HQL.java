package com.hib.HibernateHQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HQL {

	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("from Student");
		List<Student> studs = q.list();
		
		for(Student s : studs) {
			System.out.println(s);
		}
		
//		Random random = new Random();
//		int minimumAge = 18;
//		
//		List<String> imena = new ArrayList<String>();
//		imena.add("Mitar Mitrovic");
//		imena.add("Petar Petrovic");
//		imena.add("Milos Obilic");
//		imena.add("Jelena Karleusa");
//		imena.add("Zlatibor Loncar");
//		imena.add("Aleksandar Vucic");
//		imena.add("Sandra Afrika");
//		imena.add("Goran Vesic");
//		imena.add("Vuk Karadzic");
//		imena.add("Radmila Manojlovic");
//		
//		for(int i = 101; i <= 150; i++) {
//			int godine = minimumAge + random.nextInt(10);
//			String ime = imena.get(random.nextInt(10));
//			
//			Student student = new Student();
//			student.setBroj(i);
//			student.setIme(ime);
//			student.setGodine(godine);
//			session.persist(student);
//		}
		
		session.getTransaction().commit();
		
	}
	
}
