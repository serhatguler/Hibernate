package hb07.bi_onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class University03 {

    @Id
    private long id;

    @Column(name = "uni_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "university")
    private List<Student07> student;

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

    public List<Student07> getStudents() {
        return student;
    }

    public void setStudents(List<Student07> students) {
        this.student = students;
    }

    @Override
    public String toString() {
        return "University03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", students=" + students +
                '}';
    }
}