package hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(University09.class)
                .addAnnotatedClass(Student09.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        //University09 university = session.get(University09.class,1L); university geldi cunku fetch i lazy
        Student09 student1 = session.get(Student09.class, 1L);//student+university



        tx.commit();
        session.close();

        sessionFactory.close();


    }
}
