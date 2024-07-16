package hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(University08.class)
                .addAnnotatedClass(Student08.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student08 student1 = session.get(Student08.class, 1L);
        System.out.println(student1);

        University08 university1 = session.get(University08.class, 2L);
        System.out.println(university1);

        System.out.println(university1.getStudents());


        tx.commit();
        session.close();
        sessionFactory.close();

    }

}
