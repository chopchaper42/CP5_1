package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VehicleAssemblyBuildingKey implements Serializable {
//    @JoinColumn(name = "center")
//    @ManyToOne
    private String centerName;
//    @Column(name = "number")
//    @Id
    private int number;

    protected VehicleAssemblyBuildingKey() {}
    public VehicleAssemblyBuildingKey(String center, int number) {
        this.centerName = center;
        this.number = number;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
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

        VehicleAssemblyBuildingKey that = (VehicleAssemblyBuildingKey) o;

        if (!Objects.equals(centerName, that.centerName)) return false;
        if (number != that.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = centerName.hashCode();
        result = 31 * result + number;
        return result;
    }
}
