package clothingstore.repositories;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BaseEntityManager {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(
        "ClothesShopPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf.isOpen()) {
            return emf;
        } else {
            return Persistence.createEntityManagerFactory("ClothesShop");
        }
    }
}
