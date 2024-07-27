package clothingstore.repository;

import static org.junit.jupiter.api.Assertions.*;

import clothingstore.model.TypeDTO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class TypeRepositoryTest {

    private TypeRepository typeRepository;
    private EntityManagerFactory emf;

    @BeforeEach
    public void setUp() {
        emf = MyEntityManager.getEntityManagerFactory();
        typeRepository = new TypeRepository(emf);
    }

    @Test
    @Order(1)
    @Transactional
    public void testSaveType() {
        TypeDTO type = new TypeDTO();
        type.setName("Test Type");

        typeRepository.saveType(type);

        TypeDTO retrievedType = typeRepository.getTypeById(type.getId());
        assertNotNull(retrievedType);
        assertEquals("Test Type", retrievedType.getName());
    }

    @Test
    @Order(2)
    public void testGetTypeById() {
        TypeDTO type = typeRepository.getTypeById(1);
        assertNotNull(type);
        assertEquals("Test Type", type.getName());
    }

    @Test
    @Order(3)
    public void testGetAllTypes() {
        List<TypeDTO> types = typeRepository.getAllTypes();
//            assertEquals(6, types.size());
        assertEquals("Test Type", types.get(0).getName());
    }

}