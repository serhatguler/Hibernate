package hb12.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RunnerFetch12 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student12.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        /*
                Sik kullandigi datalari onbellege(cache) kaydeder.

                1) First Level Cache: Session-Level Cache
                        - Nesne icin kullanilir.
                        - Defaultta acik geliyor, kapatilma durumu yok
                        - Ayni session icinde kayit alinir
                        - Session kapaninca icindekiler silinir.
                2) Second Level Cache: - SessionFactory-Level Cache
                        - Nesne icin kullanilir.
                        - Defaultta kapalidir
                        - Session Factory seviyesinde cacheleme yapar, yani farki sessionlar arasinda data kullanabiliyor.
                        - ayni data ayni session da first level cacheden gelir
                        - ayni data farkli session da second  level cacheden gelir
                        - hibernate.cfg.xml den active edilir.

                        3) Query Cache
                            -Queryler icin kullanilir
                            -first/level cache ile kullanilabilir.
                            second level cache aktif ise DB ye gitmez .Cache den getirir.


         */

        System.out.println("1st Get Method for Student with ID: 1");
        Student12 student1 = session.get(Student12.class, 1L);

        //session.clear(); // will empty whole sessions memory

        System.out.println("2nd Get Method for Student with ID: 1");
        Student12 student2 = session.get(Student12.class, 1L);

        //RESULT: First level cache de ayni sessin da ayni objeyi fetch etmek istedigimizde
        //        Ilk kez DB ye gider daha sonraki Fetch lerde acacheden getirir.

        tx.commit();
        session.close();



        Session session2 = sessionFactory.openSession();
        Transaction tx2 = session2.beginTransaction();

        System.out.println("3rd Get Method for Student with ID: 1, IN ANOTHER SESSION NOW");
        Student12 student3 = session2.get(Student12.class, 1L);

        tx2.commit();
        session2.close();
        /*

            query cache i kullanmak icin configde ayarlari yaptik
            querynin sonucunun cache e yazilmasini / okunmasi icin setCacheable i true yapmaliyiz.

         */
        Query query = session.createQuery("FROM STUDENT12").setCacheable(true);
        query.getResultList();


        sessionFactory.close();


    }
}
