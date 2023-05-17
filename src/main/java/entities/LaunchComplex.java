package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "launch_complex", schema = "cp3", catalog = "vorongri")
@IdClass(LaunchComplexKey.class)
public class LaunchComplex {
    @Id
    @ManyToOne
    @Column(name = "center")
    private SpaceCenter center;
    @Id
    @Column(name = "number")
    private int number;
    @Basic
    @Column(name = "type")
    private String type;

    protected LaunchComplex() {}
    public LaunchComplex(LaunchComplexKey key, String type) {
        center = key.getCenter();
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LaunchComplex that = (LaunchComplex) o;

        if (center != that.center) return false;
        if (number != that.number) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = center.hashCode();
        result = 31 * result + number;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
