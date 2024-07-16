package hb02.embeddable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_student02") // Optional
public class  Student02 {
    /*

            Embeddable: Necessary to make a class Embeddable.
            Embedded: Not necessary since we already have the class as Embeddable.

            Datalari fetch ederken Hibernate parametresiz constructor kullanir.

     */

    @Id //Primary Key
    private long id;
    private String name;
    private int grade;

    //Address
    @Embedded // Optional
    private Address address;


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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +
                '}';
    }
}
