package com.luv2code.hibernate.main;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();



        try {
            int studentId = 1;

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting Student with id: " + studentId);

            Student student = session.get(Student.class, studentId);

            System.out.printf("updating student Student: \n");

            student.setFirstName("Scooby");

            System.out.println(student);

            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update email for all students");

            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
