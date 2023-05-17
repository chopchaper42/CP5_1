import entities.AerospaceCompany;
import entities.Astronaut;
import entities.Person;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");){
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            EntityRepository repository = new EntityRepository(entityManager);
            List<AerospaceCompany> companies = repository.getAllAerospaceCompanies();

            companies.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
