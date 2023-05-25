package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

@Entity
@Table(name = "launch", schema = "cp3", catalog = "vorongri")
//@IdClass(LaunchKey.class)
public class Launch {
    @Id
    private LaunchKey key;

    protected Launch() {}
    public Launch(LaunchKey key) {
        this.key = key;
    }

    public Astronaut getAstronaut() {
        return key.getAstronaut();
    }

    public void setAstronaut(Astronaut astronaut) {
        key.setAstronaut(astronaut);
    }

    public AerospaceCompany getCompany() {
        return key.getCompany();
    }

    public void setCompany(AerospaceCompany company) {
        key.setCompany(company);
    }

    public Rocket getRocket() {
        return key.getRocket();
    }

    public void setRocket(Rocket rocket) {
        key.setRocket(rocket);
    }

    public String getDate() {
        return key.getDate();
    }

    public void setDate(String date) {
        key.setDate(date);
    }

    public String getTime() {
        return key.getTime();
    }

    public void setTime(String time) {
        key.setTime(time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Launch that = (Launch) o;

        if (key.getAstronaut() != that.getAstronaut()) return false;
        if (key.getCompany() != that.getCompany()) return false;
        if (key.getRocket() != that.getRocket()) return false;
        if (key.getDate() != null ? !key.getDate().equals(that.getDate()) : that.getDate() != null) return false;
        if (key.getTime() != null ? !key.getTime().equals(that.getTime()) : that.getTime() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getAstronaut().hashCode();
        result = 31 * result + getCompany().hashCode();
        result = 31 * result + getRocket().hashCode();
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getTime() != null ? getTime().hashCode() : 0);
        return result;
    }
}
