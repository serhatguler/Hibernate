package hb05.uni_manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "t_student05")
public class Student05 {//many side
    @Id
    private long id;
    private String name;
    private int grade;

    // Creation Time and Date for the Student object
    private LocalDateTime creationDate;

    // PrePersist: Will be executed the time .save has executed.
    @PrePersist//bu classin objesi persist edilmeden(DB ye eklenmeden once) bu metodu cagirir.
    public  void prePersist(){
        creationDate = LocalDateTime.now();
    }

    //FK MAny side tarafinda olusturulur.
    //University
    @ManyToOne//student tablosunda FK olustur,
    @JoinColumn(name = "uni_id") //defaultta university_id
    private University university;

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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", creationDate=" + creationDate +
                ", university=" + university +
                '}';
    }
}
