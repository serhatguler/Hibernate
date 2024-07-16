package hb05.uni_manytoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch05 {
    public static void main(String[] args) {
        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student05.class)
                .addAnnotatedClass(University.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Task: Get the Student with ID: 1 using .get() method
        Student05 student1 = session.get(Student05.class, 1L);
        System.out.println(student1);

        University university = session.get(University.class, 1L);
        System.out.println(university);

        System.out.println(student1.getUniversity());


        tx.commit();
        session.close();
        sessionFactory.close();



    }
}
