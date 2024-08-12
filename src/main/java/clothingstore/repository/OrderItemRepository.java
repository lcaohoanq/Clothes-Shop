package clothingstore.repository;

import jakarta.persistence.EntityManagerFactory;

public class OrderItemRepository {
    private final EntityManagerFactory emf = MyEntityManager.getEntityManagerFactory();
}
