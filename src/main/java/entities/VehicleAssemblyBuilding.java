package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_assembly_building", schema = "cp3", catalog = "vorongri")
//@IdClass(VehicleAssemblyBuildingKey.class)
public class VehicleAssemblyBuilding {
    /*@Id
    @ManyToOne
    @JoinColumn(name = "center")
    private SpaceCenter center;
    @Id
    @Column(name = "number")
    private int number;*/
    @EmbeddedId
    private VehicleAssemblyBuildingKey key;

    protected VehicleAssemblyBuilding() {}
    public VehicleAssemblyBuilding(VehicleAssemblyBuildingKey key) {
        this.key = key;
    }

    public String getCenterName() {
        return key.getCenterName();
    }

    public void setCenter(String center) {
        this.key.setCenterName(center);
    }

    public int getNumber() {
        return key.getNumber();
    }

    public void setNumber(int number) {
        this.key.setNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleAssemblyBuilding that = (VehicleAssemblyBuilding) o;

        if (!key.getCenterName().equals(that.getCenterName())) return false;
        if (key.getNumber() != that.getNumber()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key.getCenterName().hashCode();
        result = 31 * result + key.getNumber();
        return result;
    }
}
