package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class LaunchKey implements Serializable {
    @JoinColumn(name = "astronaut")
    @ManyToOne
    @Id
    private Astronaut astronaut;
    @JoinColumn(name = "company")
    @ManyToOne
    @Id
    private AerospaceCompany company;
    @JoinColumn(name = "rocket")
    @ManyToOne
    @Id
    private Rocket rocket;
    @Column(name = "date")
    @Id
    private String date;
    @Column(name = "time")
    @Id
    private String time;

    public LaunchKey(Astronaut astronaut, AerospaceCompany company, Rocket rocket, String date, String time) {
        this.astronaut = astronaut;
        this.company = company;
        this.rocket = rocket;
        this.date = date;
        this.time = time;
    }

    public Astronaut getAstronaut() {
        return astronaut;
    }

    public void setAstronaut(Astronaut astronaut) {
        this.astronaut = astronaut;
    }

    public AerospaceCompany getCompany() {
        return company;
    }

    public void setCompany(AerospaceCompany company) {
        this.company = company;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LaunchKey launchKey = (LaunchKey) o;

        if (astronaut != null ? !astronaut.equals(launchKey.astronaut) : launchKey.astronaut != null) return false;
        if (company != null ? !company.equals(launchKey.company) : launchKey.company != null) return false;
        if (rocket != null ? !rocket.equals(launchKey.rocket) : launchKey.rocket != null) return false;
        if (date != null ? !date.equals(launchKey.date) : launchKey.date != null) return false;
        return time != null ? time.equals(launchKey.time) : launchKey.time == null;
    }

    @Override
    public int hashCode() {
        int result = astronaut != null ? astronaut.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (rocket != null ? rocket.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
