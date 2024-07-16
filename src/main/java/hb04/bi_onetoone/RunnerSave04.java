package hb04.bi_onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        //Creating Diaries

        Diary04 diary1 = new Diary04();
        diary1.setId(1L);
        diary1.setDiaryName("Diary1");

        Diary04 diary2 = new Diary04();
        diary2.setId(2L);
        diary2.setDiaryName("Diary2");

        Diary04 diary3 = new Diary04();
        diary3.setId(3L);
        diary3.setDiaryName("Diary3");

        // Creating the Students
        Student04 student1 = new Student04();
        student1.setId(1L);
        student1.setName("Jace");
        student1.setGrade(90);
        student1.setDiary04(diary1);

        Student04 student2 = new Student04();
        student2.setId(2L);
        student2.setName("John");
        student2.setGrade(80);
        student2.setDiary04(diary2);

        Student04 student3 = new Student04();
        student3.setId(3L);
        student3.setName("Mark");
        student3.setGrade(85);
        student3.setDiary04(diary3);


        //Cift yonlu iliski olusturnca (bi directional) iliski sahibi tarafinda diger obje set edilmeli
        //aksi takdirde FK  sadece null degerler olur.
        // Setting students for diaries

        diary1.setStudent(student1);
        diary2.setStudent(student2);
        //diary3.setStudent(student3);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Diary04.class).addAnnotatedClass(Student04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);


        tx.commit();
        session.close();
        sf.close();

















    }
}
