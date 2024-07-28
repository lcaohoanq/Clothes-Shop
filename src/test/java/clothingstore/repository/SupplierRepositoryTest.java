package clothingstore.repository;

import static org.junit.jupiter.api.Assertions.*;

import clothingstore.model.SupplierDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class SupplierRepositoryTest {

    private SupplierRepository supplierRepository;

    @BeforeEach
    void setUp() {
        supplierRepository = new SupplierRepository(MyEntityManager.getEntityManagerFactory());
    }

    @Test
    @Order(1)
    @Transactional
    void saveSupplier() {
        SupplierDTO supplier = new SupplierDTO("Test Supplier", "test.jpg");
        supplierRepository.saveSupplier(supplier);
        SupplierDTO retrievedSupplier = supplierRepository.getSupplierById(supplier.getId());
        assertNotNull(retrievedSupplier);
        assertEquals("Test Supplier", retrievedSupplier.getName());
        assertEquals("test.jpg", retrievedSupplier.getImage());
    }

    @Test
    void getSupplierById() {
        SupplierDTO supplier = supplierRepository.getSupplierById(1);
        assertNotNull(supplier);
    }

    @Test
    void getData() {
        assertNotNull(supplierRepository.getData());
    }


}