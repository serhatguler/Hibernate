package hb04.bi_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student04 {
    @Id
    private long id;
    private String name;
    private  int grade;

    //Diary
    @OneToOne(mappedBy = "student")// sadece tablosunda FK olusturur .Student Tablosunda FK olusturmaz.
    //mapped by kullanilmazsa her iki tabloda FK olusur buna gerek yok
    //(mappedBy = "student") buradaki student diary04 classinda ki private Student04 student; student name ile ayni olmali
    private  Diary04 diary04;

    //Getter-setter


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Diary04 getDiary04() {
        return diary04;
    }

    public void setDiary04(Diary04 diary04) {
        this.diary04 = diary04;
    }

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                //", diary04=" + diary04 +
                '}';
    }
}
