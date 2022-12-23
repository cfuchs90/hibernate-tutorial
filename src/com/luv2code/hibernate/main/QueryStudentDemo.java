package com.luv2code.hibernate.main;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> studentList = session.createQuery("from Student").getResultList();

            displayStudents(studentList);

            studentList =  session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();

            System.out.println("DOE Students:");
            displayStudents(studentList);



            System.out.println("OR Query");

            studentList = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").getResultList();

            displayStudents(studentList);


            studentList = session.createQuery("from Student s where s.email like '%duck.com'").getResultList();
            System.out.println("Email bla.de");
            displayStudents(studentList);
            session.getTransaction().commit();
            System.out.printf("DONE!");

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        for (Student tempStudent : studentList) {
            System.out.println(tempStudent);
        }
    }
}
