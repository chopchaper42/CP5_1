package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employee", schema = "cp3", catalog = "vorongri")
public class Employee extends Person{
//    @Id
    @OneToOne
    @JoinColumn(name = "person", referencedColumnName = "person_id")
    private Person person;
    @Basic
    @Column(name = "position")
    private String position;
    @ManyToOne
    /*@JoinColumns({
            @JoinColumn(name = "person"),
            @JoinColumn(name = "position"),
            @JoinColumn(name = "supervisor")})*/
    private Employee supervisor;

    @Transient
    private List<Employee> employees;

    protected Employee() {}
    public Employee(Person person, String position, Employee supervisor) {
        this.person = person;
        this.position = position;
        this.supervisor = supervisor;
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

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
