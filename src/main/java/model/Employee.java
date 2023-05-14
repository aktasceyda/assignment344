package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
@Entity
@Table(name="Employee_history")
public class Employee {
    public Employee(){
    }
    public Employee(Integer id, String firstName, String lastName, Date dateofBirth, String gender, Integer weight, Integer height, Timestamp date2, Double indexResult, Integer indexRange) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.date2 = date2;
        this.indexResult = indexResult;
        this.indexRange = indexRange;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "dateofBirth")
    private Date dateofBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "height")
    private Integer height;
    @Column(name = "date2")
    private Timestamp date2;
    @Column(name = "indexResult")
    private Double indexResult;
    @Column(name = "indexRange")
    private Integer indexRange;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Timestamp getDate2() {
        return date2;
    }

    public void setDate2(Timestamp date2) {
        this.date2 = date2;
    }

    public Double getIndexResult() {
        return indexResult;
    }

    public void setIndexResult(double indexResul) {

        this.indexResult = indexResul;
        if (indexResult< 18.5) {
            setIndexRange(Integer.valueOf("Underweight"));
        } else if (indexResult < 25) {
            setIndexRange(Integer.valueOf("Normal weight"));
        } else if (indexResult < 30) {
            setIndexRange(Integer.valueOf("Overweight"));
        } else {
            setIndexRange(Integer.valueOf("Obese"));
        }

    }

    public Integer getIndexRange() {
        return indexRange;
    }

    public void setIndexRange(Integer indexRange) {

        this.indexRange = indexRange;
    }


}

