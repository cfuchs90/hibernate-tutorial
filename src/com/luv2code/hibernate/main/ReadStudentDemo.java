package com.luv2code.hibernate.main;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new student object");

            Student student = new Student("Daffy", "Duck", "daffy@duck.com");

            session.beginTransaction();

            System.out.println("Saving student to database");
            System.out.println(student);

            session.save(student);

            session.getTransaction().commit();

            System.out.println("Student generated id: " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + student.getId());

            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("My Student: \n");
            System.out.println(myStudent);
            System.out.printf("DONE!");

        } finally {
            factory.close();
        }
    }
}
