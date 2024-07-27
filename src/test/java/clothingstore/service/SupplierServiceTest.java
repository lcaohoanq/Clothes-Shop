package clothingstore.service;

import static org.junit.jupiter.api.Assertions.*;

import clothingstore.model.SupplierDTO;
import clothingstore.repository.MyEntityManager;
import clothingstore.repository.SupplierRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class SupplierServiceTest {

    private EntityManagerFactory emf;
    private SupplierRepository supplierRepository;

    @BeforeEach
    void setUp() {
        emf = MyEntityManager.getEntityManagerFactory();
        supplierRepository = new SupplierRepository(emf);
    }

    @Test
    @Order(1)
    @Transactional
    void saveSupplier() {
        SupplierDTO supplier = new SupplierDTO();
        supplier.setName("Test Supplier");
        supplier.setImage("test.jpg");

        supplierRepository.saveSupplier(supplier);

        SupplierDTO retrievedSupplier = supplierRepository.getSupplierById(supplier.getId());
        assertNotNull(retrievedSupplier);
        assertEquals("Test Supplier", retrievedSupplier.getName());
    }

    @Test
    @Order(2)
    @Transactional
    void getData() {
        List<SupplierDTO> supplierList = supplierRepository.getData();
        assertNotNull(supplierList);
        assertEquals(1, supplierList.size());
    }

    @Test
    @Order(3)
    @Transactional
    void getSupplierById() {
        SupplierDTO supplier = supplierRepository.getSupplierById(1);
        assertNotNull(supplier);
        assertEquals("Test Supplier", supplier.getName());
    }
}