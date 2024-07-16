package hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        /*

                There are three ways to FETCH data.

                    1. get(Data Type, Primary Key);
                    2. SQL
                    3. HQL (Hibernate Query Language)

         */

        // 1st Way: Get Method
//        Student student1 = session.get(Student.class, 1L);//select * from t_student01 where student_id=1;
//        Student student2 = session.get(Student.class, 2L);
//        Student student3 = session.get(Student.class, 3L);
//        Student student4 = session.get(Student.class, 4L);
//
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
//        System.out.println(student4);
//
//        // 2nd Way: SQL
//        String sqlQuery = "SELECT * FROM t_student01";
//
//        //List<Object[]> resultList1 = session.createSQLQuery(sqlQuery).getResultList();
//        List<Object[]> resultList1 = session.createNativeQuery(sqlQuery).getResultList();//Object[] gelmesinin sebebi birden fazla degisken var
//
//        for (Object[] obj : resultList1){
//            System.out.println(Arrays.toString(obj));
//        }

        // 3rd Way: HQL (Hibernate Query Language)
        /*
                Java bilesenlerini kullanilir.
                With HQL, we are not going to use the names from the Database, but our classes and objects.

         */
        String hqlQuery1 = "FROM Student"; // SELECT * FROM t_student01
        List<Student> students = session.createQuery(hqlQuery1, Student.class).getResultList();
        for (Student stu : students){
            System.out.println(stu);
        }

        //Task: Get the student with name John using SQL.
        String sqlQuery2 = "SELECT * FROM t_student01 WHERE stu_name = 'John'";
        List<Object[]> resultList2 = session.createNativeQuery(sqlQuery2).getResultList(); //SQL Object[] array dondurur
        for (Object[] stu : resultList2){
            System.out.println(stu);
        }

        // Task: Get the student with name John using HQL.
        String hqlQuery2 = "FROM Student s WHERE s.name = 'John'"; //s ALIAS
        Student student5 = session.createQuery(hqlQuery2, Student.class).uniqueResult(); // uniqueresult only use for one data
        System.out.println(student5);


        //**************************************************8
        // Task: Get the students whose grade is less than 90 using HQL.
        // SELECT * FROM t_student01 WHERE grade<90;
        List<Student> students2 = session.createQuery("FROM Student s WHERE s.grade<90", Student.class).getResultList();
        System.out.println(students2);

        // SELECT s.stu_name FROM t_student01 s WHERE s.grade<90;
        // Task: Get the students names whose grade is less than 90 using HQL.
        String hqlQuery3 = "SELECT s.name FROM Student s WHERE s.grade<90";
        List<String> students3 = session.createQuery(hqlQuery3, String.class).getResultList();
        System.out.println(students3);

    //AlIAS Class adindan sonra isim verilir.



        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
