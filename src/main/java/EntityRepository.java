import entities.AerospaceCompany;
import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.Type;
import java.util.List;

public class EntityRepository {
    EntityManager manager;
    EntityTransaction transaction;

    public EntityRepository(EntityManager manager) {
        if (manager == null)
            throw new IllegalArgumentException("EntityManager was null");
        this.manager = manager;
        this.transaction = manager.getTransaction();
    }

    public List<AerospaceCompany> getAllAerospaceCompanies() {
        transaction.begin();
        TypedQuery<AerospaceCompany> query = manager.createQuery("SELECT S FROM AerospaceCompany S", AerospaceCompany.class);
        transaction.commit();
        return query.getResultList();
    }

    public List<Employee> getEmployeesWithoutSupervisors() {
        transaction.begin();
        transaction.commit();
//        TypedQuery<Employee> query = manager.createQuery("SELECT e FROM Employee E WHERE E.")
    }
}
