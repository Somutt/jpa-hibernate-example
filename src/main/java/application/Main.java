package application;

import dominion.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
        EntityManager em = emf.createEntityManager();

        persistDemo(em);
        //findDemo(em);
        //removeDemo(em);
        System.out.println("Done!");

        em.close();
        emf.close();
    }

    public static void persistDemo(EntityManager em) {
        em.getTransaction().begin();
        Person person = new Person(null, "Example", "example@email.com");
        em.persist(person);
        em.getTransaction().commit();
    }

    public static void findDemo(EntityManager em) {
        Person person = em.find(Person.class, 1);
        System.out.println(person);
    }

    public static void removeDemo(EntityManager em) {
        em.getTransaction().begin();
        Person person = em.find(Person.class, 1);
        em.remove(person);
        em.getTransaction().commit();
    }

}
