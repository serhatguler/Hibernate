package hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student04.class)
                .addAnnotatedClass(Diary04.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Get the Student with ID: 1, using get() method.
        /*
        Student04 student1 = session.get(Student04.class, 1L);
        System.out.println(student1.getDiary04());

        Diary04 diary1 = session.get(Diary04.class, 1L);
        System.out.println(diary1.getStudent());
        */

        System.out.println("******** INNER JOIN ********");
        // Task: Get the Student and Diary names
        String hql1 = "SELECT d.diaryName, s.name FROM Student04 s INNER JOIN FETCH Diary04 d ON s.id = d.student.id";
        List<Object[]> resultList1 = session.createQuery(hql1).getResultList();
        for (Object[] obj : resultList1){
            System.out.println(Arrays.toString(obj));
        }

        System.out.println("******** LEFT JOIN ********");
        String hql2 = "SELECT d.diaryName, s.name FROM Student04 s LEFT JOIN FETCH Diary04 d ON s.id = d.student.id";
        List<Object[]> resultList2 = session.createQuery(hql2).getResultList();
        for (Object[] obj : resultList2){
            System.out.println(Arrays.toString(obj));
        }

        System.out.println("******** RIGHT JOIN ********");
        String hql3 = "SELECT d.diaryName, s.name FROM Student04 s RIGHT JOIN FETCH Diary04 d ON s.id = d.student.id";
        List<Object[]> resultList3 = session.createQuery(hql3).getResultList();
        for (Object[] obj : resultList3){
            System.out.println(Arrays.toString(obj));
        }

        System.out.println("******** FULL JOIN ********");
        String hql4 = "SELECT d.diaryName, s.name FROM Student04 s FULL JOIN FETCH Diary04 d ON s.id = d.student.id";
        List<Object[]> resultList4 = session.createQuery(hql4).getResultList();
        for (Object[] obj : resultList4){
            System.out.println(Arrays.toString(obj));
        }


        tx.commit();
        session.close();
        sessionFactory.close();


    }
}
