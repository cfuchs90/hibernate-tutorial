package com.luv2code.hibernate.main;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new student object");

            Student student = new Student("Paul", "Wall", "paulwall@bla.de");

            session.beginTransaction();

            System.out.println("Saving student to database");
            session.save(student);

            session.getTransaction().commit();
            System.out.printf("DONE!");

        } finally {
            factory.close();
        }
    }
}
