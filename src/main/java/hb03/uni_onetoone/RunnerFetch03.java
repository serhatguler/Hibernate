package hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Diary.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Task: Get the student with ID: 2, using .get() method
        System.out.println("******** get() Student ********");
        Student03 student1 = session.get(Student03.class, 2L);
        System.out.println(student1);

        System.out.println("******** get() Diary ********");
        Diary diary1 = session.get(Diary.class,2L);
        System.out.println(diary1);
        System.out.println(diary1.getStudent());

        //id:3 olan diary sahibi olan studenti gorelim
        Diary diary3 =session.get(Diary.class,1L);
        System.out.println("id:3 olan diary sahibi: "+diary3.getStudent());




        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
