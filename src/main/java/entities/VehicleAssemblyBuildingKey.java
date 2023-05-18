package entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class VehicleAssemblyBuildingKey implements Serializable {
    private SpaceCenter center;
    private int number;

    protected VehicleAssemblyBuildingKey() {}
    public VehicleAssemblyBuildingKey(SpaceCenter center, int number) {
        this.center = center;
        this.number = number;
    }

    public void setCenter(SpaceCenter center) {
        this.center = center;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SpaceCenter getCenter() {
        return center;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleAssemblyBuildingKey that = (VehicleAssemblyBuildingKey) o;

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
