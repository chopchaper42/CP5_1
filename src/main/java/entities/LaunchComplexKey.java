package entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class LaunchComplexKey implements Serializable {
    @Column(name = "center")
    @Id
    private SpaceCenter center;
    @Column(name = "number")
    @Id
    private int number;

    protected LaunchComplexKey() {}
    public LaunchComplexKey(SpaceCenter center, int number) {
        this.center = center;
        this.number = number;
    }

    public SpaceCenter getCenter() {
        return center;
    }

    public void setCenter(SpaceCenter center) {
        this.center = center;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LaunchComplexKey that = (LaunchComplexKey) o;

        if (center != that.center) return false;
        if (number != that.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = center.hashCode();
        result = 31 * result + number;
        return result;
    }
}
