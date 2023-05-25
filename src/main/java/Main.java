import entities.*;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");){
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            EntityRepository repository = new EntityRepository(entityManager);
//            List<AerospaceCompany> companies = repository.getFirst10AerospaceCompanies();

            /*System.out.println("\n-*-*-*-*-*-*- All Aerospace companies: -*-*-*-*-*-*-");
            companies.forEach(System.out::println);
            System.out.println("-*-*-*-*-*-*- END -*-*-*-*-*-*-\n");*/

            /*Person person = new Person("Alexpip", "qw123ty@123432.com");
            repository.createPerson(person);*/

            /*SpaceCenter center = new SpaceCenter(1, "Kennedy Space Center", "The Long Highway 123");
            repository.updateSpaceCenter(center);*/

            /*VehicleAssemblyBuilding building = new VehicleAssemblyBuilding(
                    new VehicleAssemblyBuildingKey(
                            new SpaceCenter(6, "Space Center F", "Sherlock   Boulevard, 8949"),
                            34
                    )
            );
            repository.deleteVAB(building);*/

            /*Launch launch = new Launch(new LaunchKey(
                    103, 14, 204, new Date(2022, 10, 20), new Time(12, 32, 10)
            ));
            repository.createLaunch(launch);*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
