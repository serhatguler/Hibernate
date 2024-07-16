package hb10.idgeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {

        Student10 student1 = new Student10();
        //student1.setId();
        student1.setName("Jace");
        student1.setGrade(90);

        Student10 student2 = new Student10();
        //student1.setId();
        student2.setName("John");
        student2.setGrade(80);

        Student10 student3 = new Student10();
        //student1.setId();
        student3.setName("Mark");
        student3.setGrade(85);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student10.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
