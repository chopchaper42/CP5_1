import entities.AerospaceCompany;
import entities.Person;
import entities.SpaceCenter;
import entities.VehicleAssemblyBuilding;
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

    public List<AerospaceCompany> getFirst10AerospaceCompanies() {
        transaction.begin();
        TypedQuery<AerospaceCompany> query = manager.createQuery("SELECT S FROM AerospaceCompany S", AerospaceCompany.class);
        query.setMaxResults(10);
        transaction.commit();
        return query.getResultList();
    }

    public void createPerson(Person person) {
        transaction.begin();
        /*manager.createNativeQuery("INSERT INTO cp3.person (name, email) VALUES (?,?)")
                        .setParameter(1, person.getName())
                        .setParameter(2, person.getEmail())
                        .executeUpdate();*/
        manager.persist(person);
        transaction.commit();
        System.out.println("Inserted");
//        TypedQuery<Employee> query = manager.createQuery("SELECT e FROM Employee E WHERE E.")
    }

    public void updateSpaceCenter(SpaceCenter center) {
        transaction.begin();
        manager.merge(center);
        transaction.commit();
    }

    public void deleteVAB(VehicleAssemblyBuilding vab) {
        transaction.begin();
        vab = manager.merge(vab);
        manager.remove(vab);
        transaction.commit();
    }
}
