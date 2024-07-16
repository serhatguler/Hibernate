package hb06.uni_onetomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class University02 {//one side

    @Id
    private long id;

    @Column(name = "uni_name", nullable = false, unique = true)
    private String name;

    @OneToMany//Fk sutunu eklenemez one side bu yuzden 3.tablo olusturur.{join table:std_id-->book_id}
    @JoinColumn(name = "student_id")//kullaniuldiginda FK sutunu diger tabloda {Book tablosu} olusturur.,aksi halde yukaridaki tablo olusur.
    private List<Student06> student;//many

    // Getter & Setter
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

    public List<Student06> getStudent() {
        return student;
    }

    public void setStudent(List<Student06> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "University02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}