import entities.AerospaceCompany;
import entities.Test;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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

    public Test getTest(int id) {
        transaction.begin();
        TypedQuery<Test> query = manager.createQuery(
                "SELECT T FROM Test T WHERE T.testId = :id",
                Test.class
        );
        query.setParameter("id", id);
        transaction.commit();
        return query.getSingleResult();
    }
}
