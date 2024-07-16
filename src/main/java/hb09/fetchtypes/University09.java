package hb09.fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class University09 {

    /*
            cascade = CascadeType.ALL university tablosuna git burada yapacagin tum islemleri iliskili oldugun
            yani private List<Student09> students = new ArrayList<>(); icinde yap.
            silmek istersen once book tablosunu sil daha sonra student tablosundan da sil
            Lazy:
                OneToMany
                ManyToMany

            Eager:
                ManyToOne
                OneToOne

     */

    @Id
    private long id;

    private String name;

    // Students
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student09> students = new ArrayList<>();

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

    public List<Student09> getStudents() {
        return students;
    }

    public void setStudents(List<Student09> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "University09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
