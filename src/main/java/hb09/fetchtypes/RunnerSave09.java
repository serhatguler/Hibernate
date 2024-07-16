package hb09.fetchtypes;

import hb08.manytomany.Student08;
import hb08.manytomany.University08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {
        University09 university = new University09();
        university.setId(1L);
        university.setName("A");

        Student09 student1 = new Student09();
        student1.setId(1L);
        student1.setName("Jace");
        student1.setGrade(90);
        student1.setUniversity(university);

        Student09 student2 = new Student09();
        student2.setId(2L);
        student2.setName("John");
        student2.setGrade(80);
        student2.setUniversity(university);

        Student09 student3 = new Student09();
        student3.setId(3L);
        student3.setName("Mark");
        student3.setGrade(85);
        student3.setUniversity(university);

        Student09 student4 = new Student09();
        student4.setId(4L);
        student4.setName("X");
        student4.setGrade(85);
        //student4.setUniversity(university);

        // Setting the Students for the University
        university.getStudents().add(student1);
        university.getStudents().add(student2);
        university.getStudents().add(student3);
        university.getStudents().add(student4);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(University09.class)
                .addAnnotatedClass(Student09.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(university);

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);




        tx.commit();
        session.close();
        sessionFactory.close();


    }
}
