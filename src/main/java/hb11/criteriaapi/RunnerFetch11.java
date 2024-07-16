package hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student11.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        /*

                CRUD ( Create, Read, Update, Delete)

                    C --> session.save()
                    R --> session.get(), HQL, SQL
                    U --> session.update()
                    D --> session.delete()

         */

        // Update an existing data

        /*
        Student11 student = session.get(Student11.class, 1L);
        student.setName("Updated Student1");
        session.update(student);
        Student11 student1 = session.get(Student11.class, 1L);
        System.out.println(student1);
         */


        // Update an existing data with queries
        // Update the grades that are less than 50, to 70.
        //String hqlQuery = "UPDATE Student11 s SET s.grade = 70 WHERE s.grade<50";


        int sGrade = 50; // oldGrade
        int lGrade = 70; // newGrade
        String hqlQuery1 = "UPDATE Student11 s SET s.grade =: newGrade WHERE s.grade <: oldGrade";

        Query query = session.createQuery(hqlQuery1);
        query.setParameter("newGrade", lGrade);
        query.setParameter("oldGrade", sGrade);

        int numberOfUpdatedRows = query.executeUpdate();
        System.out.println("Number of Updated Rows: "+ numberOfUpdatedRows);


        // -------------------------CRITERIA API-------------------------------

        //HQL-SQL STRING BAZLI VE HATAYA ACIK
        //Criteria java kodlarini kullanarak programatik sorgulama yapar.
        //Hatalar azalir ve derleme aninda hata almamizi saglar.
        //criteria api ile CRUD islemlerini
        //READ: CriteriaQuery(select)
        //UPDATE: CriteriaUpdate
        //DELETE: CriteriaDelete

        // CRITERIA API
        CriteriaBuilder builder = session.getCriteriaBuilder();//1st step
        CriteriaQuery<Student11> criteriaQuery = builder.createQuery(Student11.class);//2nd Step

        Root<Student11> root = criteriaQuery.from(Student11.class); //FROM Student11 OR SELECT * FROM Student11

        //Get All The Students --> SELECT
        criteriaQuery.select(root); // SELECT * FROM Student11

        //HOw to Execute Query
        Query<Student11> query1 = session.createQuery(criteriaQuery);
        List<Student11> resultList = query1.getResultList();
        System.out.println(resultList);

        // Get the Student whose name is "Student5"
        // SQL: SELECT * FROM student11 WHERE name = "Student5"
        criteriaQuery.select(root)//SELECT * FROM student11
                .where(builder.equal(root.get("name"), "Student5")); // WHERE name = "Student5"

        //HOw to Execute Query
        Query<Student11> query2 = session.createQuery(criteriaQuery);
       // unique data oldugundan List<Student11> resultList2 = query2.getResultList();
        Student11 student = query2.uniqueResult();
        System.out.println(student);

        // Fetch students whose grade is more than 80.
        // SQL: SELECT * FROM student11 WHERE grade > 80
        criteriaQuery.select(root)
                .where(builder.greaterThan(root.get("grade"), 80));

        //HOw to Execute Query
        Query<Student11> query3 = session.createQuery(criteriaQuery);
        List<Student11> resultList2 = query3.getResultList();
        System.out.println(resultList2);


        // Fetch the students whose grade is less than 90.
        // SQL: SELECT * FROM student11 WHERE grade < 90
       criteriaQuery.select(root) //SELECT * FROM student11
                       .where(builder.lessThan(root.get("grade"), 90)); //WHERE grade < 90
        Query<Student11> query4 = session.createQuery(criteriaQuery);
        List<Student11> resultList3 = query4.getResultList();
        System.out.println(resultList3);

        // PREDICATE, READY UP QUERIES / SAVED COMMANDS
        // Find Students whose id is equal to 1, or grade is greater than 80.
        // SQL: SELECT * FROM student11 WHERE id = 1 OR grade > 80
        criteriaQuery.select(root)
                .where(builder.or(builder.equal(root.get("id"),1),builder.greaterThan(root.get("grade"), 80)));

        Predicate predicateForId = builder.equal(root.get("id"), 1); // id=1
        Predicate predicateForGrade = builder.greaterThan(root.get("grade"), 80); // grade > 80

        Predicate predicateForOr = builder.or(predicateForId, predicateForGrade); // id=1 OR grade>80

        criteriaQuery.where(predicateForOr); // WHERE id=1 OR grade>80

        Query<Student11> query5 = session.createQuery(criteriaQuery);
        List<Student11> resultList4 = query5.getResultList();
        System.out.println(resultList4);

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
