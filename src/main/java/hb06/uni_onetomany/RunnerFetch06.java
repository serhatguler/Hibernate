package hb06.uni_onetomany;

import com.sun.jdi.ObjectReference;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(University02.class)
                .addAnnotatedClass(Student06.class);
        SessionFactory sessionFactory = con.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Fetch a student using .get() method
        Student06 student1 = session.get(Student06.class, 1L);
        System.out.println(student1);

        University02 university = session.get(University02.class, 1L);
        System.out.println(university);

        tx.commit();
        session.close();


        Session session2 = sessionFactory.openSession();
        Transaction tx2 = session2.beginTransaction();

        System.out.println("******** Fetch the Students from the University whose id is 1, using HQL. ********");
        // When you don't fetch two tables, but a table and for example a list, we don't write FETCH keyword there.
        String hqlQuery1 = "SELECT s.id, s.name FROM University02 u INNER JOIN u.student s WHERE u.id= 1";
        List<Object[]> resultList1 = session2.createQuery(hqlQuery1).getResultList();
        for (Object[] obj : resultList1){
            System.out.println(Arrays.toString(obj));
        }

        tx2.commit();
        session2.close();


        sessionFactory.close();

    }
}