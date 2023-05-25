package entities;
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
import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_assembly_building", schema = "cp3", catalog = "vorongri")
@IdClass(VehicleAssemblyBuildingKey.class)
public class VehicleAssemblyBuilding {
    /*@Id
    @ManyToOne
    @JoinColumn(name = "center")
    private SpaceCenter center;*/

    @Id private int number;

    protected VehicleAssemblyBuilding() {}
    public VehicleAssemblyBuilding(VehicleAssemblyBuildingKey key) {
        /*this.center = key.getCenter();
        this.number = key.getNumber();*/
//        this.center = key.getCenter();
        this.number = key.getNumber();
    }

//    public SpaceCenter getCenter() {
//        return center;
//    }

//    public void setCenter(SpaceCenter center) {
//        this.key.setCenter(center);
//    }

    public int getNumber() {
        return number;
    }

//    public void setNumber(int number) {
//        this.key.setNumber(number);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleAssemblyBuilding that = (VehicleAssemblyBuilding) o;

//        if (center != that.getCenter()) return false;
        if (number != that.getNumber()) return false;

        return true;
    }

    @Override
    public int hashCode() {
//        int result = center.hashCode();
        int result = 31 * number;
        return result;
    }
}
