package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "aerospace_company", schema = "cp3", catalog = "vorongri")
public class AerospaceCompany {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "company_id")
    private int companyId;
    private String name;
    private String owner;

    protected AerospaceCompany() {}
    public AerospaceCompany(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AerospaceCompany that = (AerospaceCompany) o;

        if (companyId != that.companyId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return companyId + "\t" + name + "\t" + owner;
    }
}
