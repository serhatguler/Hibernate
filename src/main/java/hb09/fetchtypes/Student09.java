package hb09.fetchtypes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student09 {

    @Id
    private long id;

    private String name;

    private int grade;

    //University
    @ManyToOne //fetch type eager cunku ikinci taraf many
    private  University09 university;

    //Getter-Setter
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

    public University09 getUniversity() {
        return university;
    }

    public void setUniversity(University09 university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", university=" + university +
                '}';
    }
}
