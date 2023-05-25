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
    @JoinColumn(name = "astronaut")
    private int astronaut;
    @Id
    @JoinColumn(name = "company")
    private int company;
    @Id
    @JoinColumn(name = "rocket")
    private int rocket;
    @Id
    @Column(name = "date")
    private Date date;
    @Id
    @Column(name = "time")
    private Time time;

    protected Launch() {}
    public Launch(LaunchKey key) {
        astronaut = key.getAstronaut();
        rocket = key.getRocket();
        company = key.getCompany();
        date = key.getDate();
        time = key.getTime();
    }

//    public Astronaut getAstronaut() {
//        return astronaut;
//    }

//    public void setAstronaut(Astronaut astronaut) {
//        this.astronaut = astronaut;
//    }

//    public AerospaceCompany getCompany() {
//        return company;
//    }

//    public void setCompany(AerospaceCompany company) {
//        this.company = company;
//    }

//    public Rocket getRocket() {
//        return rocket;
//    }

//    public void setRocket(Rocket rocket) {
//        this.rocket = rocket;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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
//        int result = astronaut.hashCode();
//        int result = 31 * /*result + */company.hashCode();
//        result = 31 * result + rocket.hashCode();
        int result = 31 */* result +*/ (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
