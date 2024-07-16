package hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {

    public static void main(String[] args) {


        // Creating the Students
        Student03 student1 = new Student03();
        student1.setId(1L);
        student1.setName("Jace");
        student1.setGrade(90);

        Student03 student2 = new Student03();
        student2.setId(2L);
        student2.setName("John");
        student2.setGrade(80);

        Student03 student3 = new Student03();
        student3.setId(3L);
        student3.setName("Mark");
        student3.setGrade(85);

        // Creating the Diaries
        Diary diary1 = new Diary();
        diary1.setId(1L);
        diary1.setName("Diary1");
        diary1.setStudent(student1);

        Diary diary2 = new Diary();
        diary2.setId(2L);
        diary2.setName("Diary2");
        diary2.setStudent(student2);

        Diary diary3 = new Diary();
        diary3.setId(3L);
        diary3.setName("Mark's Diary");
        diary3.setStudent(student3);

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Diary.class).
                addAnnotatedClass(Student03.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);




        transaction.commit();
        session.close();
        sessionFactory.close();





    }

}
