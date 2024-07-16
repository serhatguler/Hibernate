package hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        // Create Student objects
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Jace");
        student1.setGrade(90);

        Student student2 = new Student(2, "John", 80);

        Student student3 = new Student();
        student3.setId(3);
        student3.setName("Mark");
        student3.setGrade(85);

        Student student4 = new Student(4, "X", 90);

        /*

                configure: To specify the configuration file.
                addAnnotatedClass: To specify the classes that we are going to manipulate.

         */

        //hibernate.cfg.xml" dosyamizdaki bilgileri ve Student01 classindaki annotasyonlara gore konfigurasyin yapilir.
        //addAnnotatedClass ile Entity classimizi Hibernate e gosteriyoruz.
        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class);

        //tum uygulamada sadece birtane SF kullanilir.fakat farkli islemler icin birden fazla acilabilir.

        SessionFactory sessionFactory = con.buildSessionFactory();//Db ile ilgili islemlerin yonetimini saglar

        Session session = sessionFactory.openSession();//Db de CRUD op. icin ve sorgulari cailstirmak icin metodlar icerir.

        Transaction tx = session.beginTransaction();//DB de bir transcaction baslatir.

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit(); // Sending the commands to the DB
        session.close();
        sessionFactory.close();



    }
}
