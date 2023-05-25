package entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class LaunchComplexKey implements Serializable {
//    @JoinColumn(name = "center")
    @ManyToOne
//    @Id
    private SpaceCenter center;
//    @Column(name = "number")
//    @Id
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
