package com.code.HQL;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main( String[] args ) {
    	 Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class)
         		;
         ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
         SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);       
         Session session = sessionFactory.openSession();
         Transaction tx = session.beginTransaction();
         
        
         Query query = session.createQuery("select id, name from Student");
         List<Object[]> students = (List<Object[]>)query.list();
         for (Object[] std: students) {
        	// System.out.println(std[1]);
         }
         
         //Student st = (Student)query.uniqueResult();
         //System.out.println()
         
         Laptop laptop = new Laptop();
         laptop.setId(102);
         laptop.setBrand("Mac");
         session.save(laptop);
         
         tx.commit();
         session.detach(laptop);
         laptop.setBrand("HP");
    }
}