package hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity // Create a table from that class, and map objects inside it.
@Table(name = "t_student01")
//HQL:Student
//SQL:t_student01
public class Student {

    /*
            Generate Window: ALT + INSERT

            To Select All Items: CTRL/CMD + A

            To Select Multiple: Shift + Arrow Keys (UP OR DOWN)
     */

    /*

            @Entity: To create a table from a specific class
            @Table : To change some parameters/features about a table.
                name: To change the name of the column in table.
            @Id: To specify the Primary Key
            @Column (Optional): To change some parameters/features about a column.
                name: To change the name of the column in table.
                length: To specify the character limit
                nullable: To specify whether leaving the column null is possible or not.
                unique: To make a column info unique, so that it cannot be used again.

            @Transient: To hide a field from the database(table), we can use it.

            @Lob: Large Objects.

     */



    // Pojo Class
    /*

            1. private fields / variables
            2. Constructor
            3. Getter & Setter
            4. toString (Optional)

     */

    @Id // Primary Key (PK)
    private long id;

    @Column(name = "stu_name", length = 100, nullable = false, unique = false)
    private String name;

    //@Transient //bu fielda karsilik bir sutun olusturulmaz,
    private int grade;

    /*
    @Lob
    private byte[] image;
     */


    // Constructor
    /*
            Student.setId(1);
            Student.setName("Jace");
            Student.setGrade(90);
     */
    public Student() {

    }

    // new Student(1, "Jace", 90);
    public Student(long id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    // toString
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}

























