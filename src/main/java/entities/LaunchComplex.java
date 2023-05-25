package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "launch_complex", schema = "cp3", catalog = "vorongri")
//@IdClass(LaunchComplexKey.class)
public class LaunchComplex {
    /*@Id
    @ManyToOne
    @JoinColumn(name = "center")
    private SpaceCenter center;
    @Id
    @Column(name = "number")
    private int number;*/
    @Id
    private LaunchComplexKey key;
    @Basic
    @Column(name = "type")
    private String type;

    protected LaunchComplex() {}
    public LaunchComplex(LaunchComplexKey key, String type) {
        this.key = key;
        this.type = type;
    }

    public SpaceCenter getCenter() {
        return key.getCenter();
    }

    public void setCenter(SpaceCenter center) {
        key.setCenter(center);
    }

    public int getNumber() {
        return key.getNumber();
    }

    public void setNumber(int number) {
        key.setNumber(number);
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

        if (key.getCenter() != that.getCenter()) return false;
        if (key.getNumber() != that.getNumber()) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key.getCenter().hashCode();
        result = 31 * result + key.getNumber();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
