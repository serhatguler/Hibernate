package hb03.uni_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_diary01")
public class Diary {//diary de student foreign key olacakgi icin iliskiyi diary table dan yonetiyoruz.

     /*

            @OneToOne: Means that you're working with a One-To-One relation there
            AND
            a student column will be created here.

     */

    @Id
    private long id;
    private  String name;
    @OneToOne // diary tablosuna student sutun u ekle bu sutun foreign key oluyor.
    @JoinColumn(name = "std_id",unique = true) //default name:student_id
    private Student03 student;

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
