package clothingstore.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class MyEntityFactory implements EntityManagerFactory {

    private static EntityManagerFactory instance;

    public static EntityManagerFactory getInstance() {
        if (instance == null) {
            instance = Persistence.createEntityManagerFactory("ClothesShop");
        }
        return instance;
    }

}
