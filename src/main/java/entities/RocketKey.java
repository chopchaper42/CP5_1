package entities;

import jakarta.persistence.*;

import java.io.Serializable;

public class RocketKey implements Serializable {
    private int rocketId;
    private int company;

    protected RocketKey() {}
    public RocketKey(int company) {
        this.company = company;
    }
    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

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
        result = 31 * result + company;
        return result;
    }
}
