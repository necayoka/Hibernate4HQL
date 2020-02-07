package com.hib.HibernateHQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{	
    public static void main( String[] args )
    {
        Student student = new Student();
        student.setBroj(18);
        student.setIme("Blagodar Lovcevic");
        student.setGodine(58);
        
        // Insert student
        save(student);
        // Insert ID
        student = get(15);
        System.out.println(student);
    }
    
	static void save(Student student) {
        Session session = openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
	}
	
	static Student get(int id) {
		Session session = openSession();
        Student student = (Student) session.get(Student.class, id);
        session.close();
        return student;
	}
	
	static Session openSession() {
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
    	SessionFactory factory = config.buildSessionFactory(reg);
        return factory.openSession();
	}
}
