package entities;

import java.io.Serializable;

public class TestId implements Serializable {
    private RocketKey rocket;
    private AerospaceCompany company;

    public TestId(RocketKey rocket, AerospaceCompany company) {
        this.rocket = rocket;
        this.company = company;
    }

    public RocketKey getRocket() {
        return rocket;
    }

    public void setRocket(RocketKey rocket) {
        this.rocket = rocket;
    }

    public AerospaceCompany getCompany() {
        return company;
    }

    public void setCompany(AerospaceCompany company) {
        this.company = company;
    }
}
