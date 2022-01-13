package com.code.HQL;

import java.util.Date;
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
    	 Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).
    			 addAnnotatedClass(Laptop.class).addAnnotatedClass(User.class).addAnnotatedClass(Vehicle.class)
         		;
         ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
         SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);       
         Session session = sessionFactory.openSession();
         Transaction tx = session.beginTransaction();
         
        
        /* Query query = session.createQuery("select id, name from Student");
         List<Object[]> students = (List<Object[]>)query.list();
         for (Object[] std: students) {
        	// System.out.println(std[1]);
         }*/
         
         //Student st = (Student)query.uniqueResult();
         //System.out.println()
         
        /* Laptop laptop = new Laptop();
         laptop.setId(102);
         laptop.setBrand("Mac");
         session.save(laptop);*/
         Vehicle vehicle = new Vehicle();
         vehicle.setId(451);
         vehicle.setName("Car");
         
         Vehicle vehicle2 = new Vehicle();
         vehicle2.setId(452);
         vehicle2.setName("Bike");
         
         
         
         User user = new User();
        // user.setId(3);
         user.setName("Mike");
         user.setAge(20);
         user.setDate(new Date());
        // user.setVehicle(vehicle);
         user.getVehicles().add(vehicle);
         user.getVehicles().add(vehicle2);
         //vehicle.getUsers().add(user);
         //vehicle2.getUsers().add(user);
         
         
         session.persist(user);
        // session.save(vehicle);
         //session.save(vehicle2);
         
         /*Student st = new Student();
         //st.setId(3);
         st.setMarks(85);
         st.setName("John");
         
         Laptop lap1 = new Laptop();
         lap1.setId(1002);
         lap1.setBrand("Asus");
         
         Laptop lap2 = new Laptop();
         lap2.setId(1001);
         lap2.setBrand("Mac");
         
         st.getLaptops().add(lap1);
         st.getLaptops().add(lap2);
         session.save(st);*/
         
         tx.commit();
         //session.detach(laptop);
         //laptop.setBrand("HP");
    }
}
