package hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave06 {
    public static void main(String[] args) {

        // University
        University02 university = new University02();
        university.setId(1L);
        university.setName("A");

        // Students
        Student06 student1 = new Student06();
        student1.setId(1L);
        student1.setName("Jace");
        student1.setGrade(90);

        Student06 student2 = new Student06();
        student2.setId(2L);
        student2.setName("John");
        student2.setGrade(80);

        Student06 student3 = new Student06();
        student3.setId(3L);
        student3.setName("Mark");
        student3.setGrade(85);

        // Setting the Students for University
        List<Student06> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        university.setStudent(students);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(University02.class)
                .addAnnotatedClass(Student06.class);
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