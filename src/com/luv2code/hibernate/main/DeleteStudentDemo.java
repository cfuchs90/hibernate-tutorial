package com.luv2code.hibernate.main;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();



        try {
            int studentId = 1;

            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            System.out.println("Getting Student with id: " + studentId);
//
//            Student student = session.get(Student.class, studentId);
//
            System.out.println("deleting student Student: \n");

//            session.delete(student);

            // delete new student

            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
