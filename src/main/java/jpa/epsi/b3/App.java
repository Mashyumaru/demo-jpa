package jpa.epsi.b3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    static void main(){
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
            EntityManager em = emf.createEntityManager();
        ){
            em.getTransaction().begin();

            // CRUD -> Create
            Personne p = new Personne("R", "T", 21);
            em.persist(p);
            System.out.println(p.getId());

            // CRUD -> Read
            Personne theo = em.find(Personne.class, 2);
            if (theo != null){
                System.out.println(theo);
            }

            // CRUD -> Update
            Personne personneModifier = em.find(Personne.class, 1);
            if (personneModifier != null){
                personneModifier.setNom("Theo");
            }

            // CRUD -> Delete
            Personne personneDeleter = em.find(Personne.class, 1);
            if (personneDeleter != null){
                em.remove(personneDeleter);
            }


            em.getTransaction().commit();

        }
    }
}
