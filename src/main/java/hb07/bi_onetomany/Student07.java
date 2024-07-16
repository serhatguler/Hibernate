package hb07.bi_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student07 {

    @Id
    private long id;

    private String name;

    private int grade;

    // University
    @ManyToOne
    private University03 university;

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

    public University03 getUniversity() {
        return university;
    }

    public void setUniversity(University03 university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", university=" + university +
                '}';
    }
}