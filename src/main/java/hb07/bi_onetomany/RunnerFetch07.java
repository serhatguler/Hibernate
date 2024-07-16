package hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(University03.class)
                .addAnnotatedClass(Student07.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student07 student1 = session.get(Student07.class, 1L);
        System.out.println(student1);

        University03 university = session.get(University03.class, 1L);
        System.out.println(university.getStudents());

        // Fetch the student name and university name from University using SQL.
        String sqlQuery1 = "SELECT s.name, u.uni_name FROM university03 u FULL JOIN student07 s ON u.id = s.university_id";
        List<Object[]> resultList1 = session.createNativeQuery(sqlQuery1).getResultList();
        for (Object[] obj : resultList1){
            System.out.println(Arrays.toString(obj));
        }

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}