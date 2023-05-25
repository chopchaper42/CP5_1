package entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class RocketKey implements Serializable {
    /*@Column(name = "rocket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id*/
//    @Column(name = "rocket_id")
    private int rocketId;
    /*@JoinColumn(name = "company")
    @ManyToOne
    @Id*/
    @ManyToOne
    private AerospaceCompany company;

    protected RocketKey() {}
    public RocketKey(AerospaceCompany company) {
        this.company = company;
    }
    public AerospaceCompany getCompany() {
        return company;
    }
    public int getRocketId() {
        return rocketId;
    }

//    public void setCompany(AerospaceCompany company) {
//        this.company = company;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RocketKey that = (RocketKey) o;

        if (rocketId != that.rocketId) return false;
        if (company != that.company) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rocketId;
        result = 31 * result + company.hashCode();
        return result;
    }
}
