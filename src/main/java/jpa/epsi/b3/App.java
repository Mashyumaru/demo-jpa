package jpa.epsi.b3;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    static void main(){
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu")){
            System.out.println(emf);
            System.out.println("Je suis connecté !!!");
        }
    }
}
