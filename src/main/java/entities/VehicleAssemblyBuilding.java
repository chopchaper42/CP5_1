package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_assembly_building", schema = "cp3", catalog = "vorongri")
//@IdClass(VehicleAssemblyBuildingKey.class)
public class VehicleAssemblyBuilding {
    /*@Id
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private Long buildingId;*/
    /*@Id
    @ManyToOne
    @JoinColumn(name = "center")
    private SpaceCenter center;
    @Basic
    private int number;*/
    @Id
    private VehicleAssemblyBuildingKey key;
    protected VehicleAssemblyBuilding() {}
    public VehicleAssemblyBuilding(VehicleAssemblyBuildingKey key) {
        /*this.center = key.getCenter();
        this.number = key.getNumber();*/
        this.key = key;
    }

    public SpaceCenter getCenter() {
        return key.getCenter();
    }

    public void setCenter(SpaceCenter center) {
        this.key.setCenter(center);
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

        if (key.getCenter() != that.getCenter()) return false;
        if (key.getNumber() != that.getNumber()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key.getCenter().hashCode();
        result = 31 * result + key.getNumber();
        return result;
    }
}
