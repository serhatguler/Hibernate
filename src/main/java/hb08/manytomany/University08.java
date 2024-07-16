package hb08.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class University08 {
    @Id
    private  long id;
    private  String name;

    //Students
    @ManyToMany(mappedBy = "universities")
    private List<Student08> students = new ArrayList<>();

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

    public List<Student08> getStudents() {
        return students;
    }

    public void setStudents(List<Student08> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "University08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", students=" + students +
                '}';
    }
}
