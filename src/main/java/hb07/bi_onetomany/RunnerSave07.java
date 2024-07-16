package hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave07 {
    public static void main(String[] args) {

        University03 university = new University03();
        university.setId(1L);
        university.setName("A");

        Student07 student1 = new Student07();
        student1.setId(1L);
        student1.setName("Jace");
        student1.setGrade(90);
        student1.setUniversity(university);

        Student07 student2 = new Student07();
        student2.setId(2L);
        student2.setName("John");
        student2.setGrade(80);
        student2.setUniversity(university);

        Student07 student3 = new Student07();
        student3.setId(3L);
        student3.setName("Mark");
        student3.setGrade(85);
        student3.setUniversity(university);

        List<Student07> student = new ArrayList<>();
        student.add(student1);
        student.add(student2);
        student.add(student3);

        university.setStudents(student);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(University03.class)
                .addAnnotatedClass(Student07.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        session.save(university);
        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sessionFactory.close();


    }
}