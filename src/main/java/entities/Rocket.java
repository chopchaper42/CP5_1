package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rocket", schema = "cp3", catalog = "vorongri")
@IdClass(RocketKey.class)
public class Rocket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rocket_id")
    private int rocketId;
    @Id
    @ManyToOne
    @Column(name = "company")
    private AerospaceCompany company;
    @Basic
    @Column(name = "serial_number")
    private String serialNumber;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "test_id")
    private int testId;

    protected Rocket() {}
    public Rocket(RocketKey key, String serialNumber, String type, int testId) {
        company = key.getCompany();
        this.serialNumber = serialNumber;
        this.type  = type;
        this.testId = testId;
    }

    public int getRocketId() {
        return rocketId;
    }

    public void setRocketId(int rocketId) {
        this.rocketId = rocketId;
    }

    public AerospaceCompany getCompany() {
        return company;
    }

    public void setCompany(AerospaceCompany company) {
        this.company = company;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rocket that = (Rocket) o;

        if (rocketId != that.rocketId) return false;
        if (company != that.company) return false;
        if (serialNumber != null ? !serialNumber.equals(that.serialNumber) : that.serialNumber != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if ( !(testId == that.testId) ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rocketId;
        result = 31 * result + company.hashCode();
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + testId;
        return result;
    }
}
