package org.example;

import org.example.model.Address;
import org.example.model.Company;
import org.example.model.Course;
import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Student student = new Student("Sashs");
        student.setCompany(new Company("Amazon"));
        student.setAddress(new Address("Тарковского, д. 1"));
        student.setCourses(List.of(new Course("Java Middle")));
        session.save(student);


        session.getTransaction().commit();
    }
}