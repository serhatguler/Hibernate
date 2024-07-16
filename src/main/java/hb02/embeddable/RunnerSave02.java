package hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

    public static void main(String[] args) {
        // Create the Address
        Address address1 = new Address();
        address1.setCountry("USA");
        address1.setCity("New York");
        address1.setStreet("Apple Street");

        Address address2 = new Address();
        address2.setCountry("USA");
        address2.setCity("Texas");
        address2.setStreet("Hibernate");

        Address address3 = new Address();
        address3.setCountry("Poland");
        address3.setCity("Warsaw");
        address3.setStreet("Sokolowska 10");

        // Create the Students

        Student02 student1 = new Student02();
        student1.setId(1L);
        student1.setName("Jace");
        student1.setGrade(90);
        student1.setAddress(address1);

        Student02 student2 = new Student02();
        student2.setId(2L);
        student2.setName("John");
        student2.setGrade(80);
        student2.setAddress(address2);

        Student02 student3 = new Student02();
        student3.setId(3L);
        student3.setName("Mark");
        student3.setGrade(90);
        student3.setAddress(address3);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);




        tx.commit();
        session.close();
        sf.close();



    }

}
