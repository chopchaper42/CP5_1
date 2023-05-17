package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_assembly_building", schema = "cp3", catalog = "vorongri")
@IdClass(VehicleAssemblyBuildingKey.class)
public class VehicleAssemblyBuilding {
    @Id
    @ManyToOne
    @Column(name = "center")
    private SpaceCenter center;
    @Id
    @Column(name = "number")
    private int number;

    protected VehicleAssemblyBuilding() {}
    public VehicleAssemblyBuilding(VehicleAssemblyBuildingKey key) {
        center = key.getCenter();
        number = key.getNumber();
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

        VehicleAssemblyBuilding that = (VehicleAssemblyBuilding) o;

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
