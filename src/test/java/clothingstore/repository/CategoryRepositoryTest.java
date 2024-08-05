package clothingstore.repository;

import static org.junit.jupiter.api.Assertions.*;

import clothingstore.model.CategoryDTO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class CategoryRepositoryTest {

    private CategoryRepository categoryRepository;
    private EntityManagerFactory emf;

    @BeforeEach
    void setUp() {
        emf = MyEntityManager.getEntityManagerFactory();
        categoryRepository = new CategoryRepository(emf);
    }

    @Test
    @Transactional
    @Order(1)
    void saveUser() {
        CategoryDTO category = new CategoryDTO();
        category.setName("Test Category");

        categoryRepository.saveCategory(category);

        CategoryDTO retrievedCategory = categoryRepository.getCategoryById(category.getId());
        assertNotNull(retrievedCategory);
        assertEquals("Test Category", retrievedCategory.getName());
    }

    @Test
    @Order(2)
    void getData() {
        List<CategoryDTO> categories = categoryRepository.getData();
        assertEquals(1, categories.size());
    }

    @Test
    @Order(5)
    void getCategoryById() {
    }

    @Test
    @Transactional
    @Order(3)
    void deleteCategory() {
    }

    @Test
    @Transactional
    @Order(4)
    void editCategory() {
    }
}