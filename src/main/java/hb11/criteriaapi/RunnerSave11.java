package hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave11 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student11.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Random random = new Random();

        // Create students with names like Student1, Student2, etc.
        // Grades will be assigned randomly, from 1 to 100.
        for (int i=1; i<21; i++){

            Student11 student = new Student11();
            student.setName("Student"+i);
            student.setGrade(random.nextInt(100)); // 1 to 100

            session.save(student);
        }



        tx.commit();
        session.close();
        sessionFactory.close();


    }

}
