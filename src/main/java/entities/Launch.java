package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

@Entity
@Table(name = "launch", schema = "cp3", catalog = "vorongri")
@IdClass(LaunchKey.class)
public class Launch {
    @Id
    @ManyToOne
    @JoinColumn(name = "astronaut")
    private Astronaut astronaut;
    @Id
    @ManyToOne
    @JoinColumn(name = "company")
    private AerospaceCompany company;
    @Id
    @ManyToOne
    @JoinColumn(name = "rocket")
    private Rocket rocket;
    @Id
    @Column(name = "date")
    private String date;
    @Id
    @Column(name = "time")
    private String time;

    protected Launch() {}
    public Launch(LaunchKey key) {
        astronaut = key.getAstronaut();
        company = key.getCompany();
        rocket = key.getRocket();
        date = key.getDate();
        time = key.getTime();
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

        Launch that = (Launch) o;

        if (astronaut != that.astronaut) return false;
        if (company != that.company) return false;
        if (rocket != that.rocket) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = astronaut.hashCode();
        result = 31 * result + company.hashCode();
        result = 31 * result + rocket.hashCode();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
