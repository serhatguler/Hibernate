package hb08.manytomany;

import hb07.bi_onetomany.Student07;
import hb07.bi_onetomany.University03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave08 {
    public static void main(String[] args) {
        //Universities
        University08 university1 = new University08();
        university1.setId(1L);
        university1.setName("A");

        University08 university2 = new University08();
        university2.setId(2L);
        university2.setName("B");

        University08 university3 = new University08();
        university3.setId(3L);
        university3.setName("C");

        //Students
        Student08 student1 = new Student08();
        student1.setId(1L);
        student1.setName("Jace");
        student1.setGrade(90);

        Student08 student2 = new Student08();
        student2.setId(2L);
        student2.setName("John");
        student2.setGrade(80);

        Student08 student3 = new Student08();
        student3.setId(3L);
        student3.setName("Mark");
        student3.setGrade(85);

        Student08 student4 = new Student08();
        student4.setId(4L);
        student4.setName("Jack");
        student4.setGrade(90);

        Student08 student5 = new Student08();
        student5.setId(5L);
        student5.setName("Zack");
        student5.setGrade(80);

        //1st Way
        /*
        List<Student08> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student3);
        students.add(student5);
        university1.setStudents(students);
        */

        //2nd Way
        university1.getStudents().add(student1);
        university1.getStudents().add(student2);

        university2.getStudents().add(student3);
        university2.getStudents().add(student4);
        university2.getStudents().add(student1);

        university3.getStudents().add(student5);

        student1.getUniversities().add(university1);
        student1.getUniversities().add(university2);

        student2.getUniversities().add(university1);

        student3.getUniversities().add(university2);
        student4.getUniversities().add(university2);

        student5.getUniversities().add(university3);



        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(University08.class)
                .addAnnotatedClass(Student08.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);

        session.save(university1);
        session.save(university2);
        session.save(university3);


        tx.commit();
        session.close();
        sessionFactory.close();




    }


}
