package entities;


import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

public class TestKey implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "rocket")
    private Rocket rocket;
    @Id
    @ManyToOne
    @JoinColumn(name = "company")
    private AerospaceCompany company;

    protected TestKey() {}
    public TestKey(Rocket rocket, AerospaceCompany company) {
        this.rocket = rocket;
        this.company = company;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public AerospaceCompany getCompany() {
        return company;
    }

    public void setCompany(AerospaceCompany company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestKey testKey = (TestKey) o;

        if (rocket != null ? !rocket.equals(testKey.rocket) : testKey.rocket != null) return false;
        return company != null ? company.equals(testKey.company) : testKey.company == null;
    }

    @Override
    public int hashCode() {
        int result = rocket != null ? rocket.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }
}
