package clothingstore.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MyEntityManager {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(
        "ClothesShop");

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf.isOpen()) {
            return emf;
        } else {
            return Persistence.createEntityManagerFactory("ClothesShop");
        }
    }
}
