import entities.AerospaceCompany;
import entities.SpaceCenter;
import entities.VehicleAssemblyBuilding;
import entities.VehicleAssemblyBuildingKey;
import jakarta.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");){
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            EntityRepository repository = new EntityRepository(entityManager);
            List<AerospaceCompany> companies = repository.getFirst10AerospaceCompanies();

            /*System.out.println("\n-*-*-*-*-*-*- All Aerospace companies: -*-*-*-*-*-*-");
            companies.forEach(System.out::println);
            System.out.println("-*-*-*-*-*-*- END -*-*-*-*-*-*-\n");*/

            /*Person person = new Person("Alexpip", "qw123ty@123432.com");
            repository.createPerson(person);*/

            /*SpaceCenter center = new SpaceCenter(1, "Kennedy Space Center", "The Long Highway 123");
            repository.updateSpaceCenter(center);*/

            VehicleAssemblyBuilding building = new VehicleAssemblyBuilding(
                    new VehicleAssemblyBuildingKey(
                            new SpaceCenter(6, "Space Center F", "Sherlock   Boulevard, 8949"),
                            34
                    )
            );
            repository.deleteVAB(building);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
