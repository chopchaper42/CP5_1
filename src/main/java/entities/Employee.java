package entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "employee", schema = "cp3", catalog = "vorongri")
public class Employee extends Person implements Serializable {
    @Id
    @OneToOne
    @PrimaryKeyJoinColumn(name = "person")
    private Person person;
    @Basic
    @Column(name = "position")
    private String position;
//    @ManyToOne
//    @JoinColumn(name = "supervisor")
    /*@JoinTable(name = "employee", joinColumns = {
            @JoinColumn(name = "person"),
            @JoinColumn(name = "position"),
            @JoinColumn(name = "supervisor")
    })
    private Employee supervisor;*/

    protected Employee() {}
    public Employee(Person person, String position, Employee supervisor) {
        this.person = person;
        this.position = position;
//        this.supervisor = supervisor;
    }

    public Person getPerson() {
        return person;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /*public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }*/
}
