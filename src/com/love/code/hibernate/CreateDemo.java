package com.love.code.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create sesion factory
		SessionFactory factory = new Configuration()
		                             .configure("hibernate.cfg.xml")
		                             .addAnnotatedClass(Instructor.class)
		                             .addAnnotatedClass(InstructorDetail.class)
		                             .buildSessionFactory();
		
		//create a session
		Session session= factory.getCurrentSession();
		
		try{
			//create the objects
		//	Instructor tempInstructor= new Instructor("Shrey", "Aggarwal","abc@gmail.com");
		//	InstructorDetail tempInstructorDetail= new InstructorDetail("shrey@travel","swimming");
			
			/*Instructor tempInstructor= new Instructor("Sam", "Sven","ss@gmail.com");
			InstructorDetail tempInstructorDetail= new InstructorDetail("sam.startupideas","badminton");
				
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			
			//it will also save tempInstructorDetail because of cascade all
			System.out.println("Saving the instructor"+tempInstructor);
			session.save(tempInstructor);
			
			
			session.getTransaction().commit();*/
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Printing the Instructor details\n");
			List<Instructor> list= session.createQuery("from Instructor").list();
			System.out.println(list);
			
			int id=9;
			Instructor inst= session.get(Instructor.class, id);
			System.out.println("Printing the instructor detail");
			System.out.println(inst.getInstructorDetail());
			
			
			session.getTransaction().commit();
			
		}
		
		finally{
			factory.close();
		}

	}

}
