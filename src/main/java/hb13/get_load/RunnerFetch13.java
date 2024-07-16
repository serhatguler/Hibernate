package hb13.get_load;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13 {
    public static void main(String[] args) {
        /*
            get   -> donen objeye hemen ihtiyac duyurlursa get kullanilir.
                  -> hemen DB ye basvurur.
                  -> obje yoksa null doner.
                  -> id ile obje oldugunda emin degilsek get kullanilmali.

            load  -> proxy(golge) doner
                  -> hemen DB ye basvurmaz. ne zaman ihtiyac duyulursa gercek nesneyi doner.
                  -> obje yoksa not found exception firlatir..
                  -> id ile obje olduguna emin degilsek load kullanilmali.
                  -> objeye reference olarak ihtiyac duyulursa  kullanilmali.



         */

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student13.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // GET METHOD
        System.out.println("******** Get Method Starts Here ********");
        //Student13 student1 = session.get(Student13.class, 1L);
        System.out.println("******** Get Method Ends Here ********");
        //System.out.println(student1.getId());
        //System.out.println(student1.getName());

        // LOAD METHOD
        /*

                Load: Creates a proxy/shadow/fake object. Not a real one.

         */
        System.out.println("******** Load Method Starts Here ********");
        Student13 student2 = session.load(Student13.class, 100L);
        System.out.println("******** Load Method Ends Here ********");
        System.out.println(student2.getId());
        try{
            System.out.println(student2.getName());
        }catch (ObjectNotFoundException e){
            System.out.println("Object Not Found");
        }


        //session.delete(student2);

        //olmayan id ile fetch edelim
//        Student13 student3 = session.load(Student13.class, 5000);
//        System.out.println(student3.getId());
//        if (student3!=null){
//            System.out.println("ID : "+ student3.getId());
//            System.out.println("Name : "+ student3.getName());
//        }


        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
