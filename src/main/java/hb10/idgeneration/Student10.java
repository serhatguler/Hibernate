package hb10.idgeneration;

import javax.persistence.*;

@Entity
@Table(name = "t_student10")
public class Student10 {
     /*

            GenerationTypes:

                GenerationType.AUTO --> Hibernate will decide which strategy to use.
                GenerationType.SEQUENCE --> Developer got some control over id properties --> OracleDB or PostgreSQL
                GenerationType.IDENTITY --> DB got the control over the id. --> MySQL or Microsoft SQL
                GenerationType.TABLE --> will create a new table to store id's.

     */

    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "sequence",// Matching the generator names
            sequenceName = "student_id",// Storing the sequence info in DB with that name
            initialValue = 1000, // Starting value (Optional)
            allocationSize = 10 // Allocated numbers count. It is 50 by default. (Optional)
    )
    @Id
    private long id;

    private String name;

    private int grade;

    // Getter & Setter
    public long getId() {
        return id;
    }

   // public void setId(long id) {
      //  this.id = id;
    //}

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

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
