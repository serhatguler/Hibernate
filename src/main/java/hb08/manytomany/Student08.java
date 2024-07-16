package hb08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "t_student08")
public class Student08 {
    @Id
    private  long id;
    private String name;
    private  int grade;

    //Universities
    @ManyToMany
    @JoinTable(
            name = "Student_University", //Table name
            joinColumns = {
                    @JoinColumn(name = "stu_id")}, //First Column Student08
            inverseJoinColumns = {
                    @JoinColumn(name= "uni_id")} //Second Column University08
    )
    private List<University08> universities = new ArrayList<>();

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

    public List<University08> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University08> universities) {
        this.universities = universities;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", universities=" + universities +
                '}';
    }
}
