package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "test", schema = "cp3", catalog = "vorongri")
//@IdClass(TestKey.class)
public class Test {
    @ManyToMany
    @JoinColumns({
            @JoinColumn(name = "rocket", referencedColumnName = "rocket_id"),
            @JoinColumn(name = "rocket", referencedColumnName = "company")
    })
    private List<Rocket> rocket;
    /*@Id
    @OneToOne
    @JoinColumn(name = "company")
    private AerospaceCompany company;*/
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "name")
    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "test_id")
    private int testId;

    protected Test() {}
    public Test(String name, String description) {
        this.name = name;
        this.description = description;
//        this.rocket = rocket;
//        this.company = company;
    }
    public Test(int id) {
        this.testId = id;
    }

//    public Rocket getRocket() {
//        return rocket;
//    }

//    public void setRocket(Rocket rocket) {
//        this.rocket = rocket;
//    }

//    public AerospaceCompany getCompany() {
//        return company;
//    }

//    public void setCompany(AerospaceCompany company) {
//        this.company = company;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test that = (Test) o;

        if (rocket != that.rocket) return false;
//        if (company != that.company) return false;
        if (testId != that.testId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rocket.hashCode();
//        result = 31 * result + company.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + testId;
        return result;
    }
}
