package hb04.bi_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary04 {
    @Id
    private  long id;
    private String diaryName;

    //Student
    @OneToOne
    //@column
    @JoinColumn(name = "stu_id", unique = true)
    private Student04 student;

    //Getter-Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary04{" +
                "id=" + id +
                ", diaryName='" + diaryName + '\'' +
                ", student=" + student +
                '}';
    }
}
