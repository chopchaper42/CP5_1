import entities.AerospaceCompany;
import entities.Astronaut;
import entities.Person;
import entities.Test;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");){
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            EntityRepository repository = new EntityRepository(entityManager);
            /*List<AerospaceCompany> companies = repository.getAllAerospaceCompanies();

            companies.forEach(System.out::println);*/

            Test test = repository.getTest(33);
            System.out.println(test.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
