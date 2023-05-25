package entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "person", schema = "cp3", catalog = "vorongri")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id")
    private int personId;
    @Basic(optional = false)
    private String email;
    @Basic(optional = false)
    private String name;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    protected Person() {}

    public int getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
