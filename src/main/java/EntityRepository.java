import entities.AerospaceCompany;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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
}
