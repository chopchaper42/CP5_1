package entities;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "astronaut", schema = "cp3", catalog = "vorongri")
public class Astronaut extends Person implements Serializable {
    @Id
    @OneToOne
    private Person person;
    @Basic(optional = false)
    @Column(name = "rank")
    private String rank;
    @Basic(optional = false)
    @Column(name = "experience")
    private int experience;

    public Astronaut(Person person, String rank, int experience) {
        this.person = person;
        this.experience = experience;
        this.rank = rank;
    }

    protected Astronaut() {}

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Person getPerson() {
        return person;
    }
}
