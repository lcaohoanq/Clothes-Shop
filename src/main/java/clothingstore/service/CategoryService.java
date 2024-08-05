package clothingstore.service;

import clothingstore.model.CategoryDTO;
import clothingstore.repository.CategoryRepository;
import clothingstore.repository.MyEntityManager;
import java.util.List;

public class CategoryService {

    private CategoryRepository categoryRepository = new CategoryRepository(MyEntityManager.getEntityManagerFactory());

    public List<CategoryDTO> getData(){
        return categoryRepository.getData();
    }

    public void saveCategory(CategoryDTO category) {
        categoryRepository.saveCategory(category);
    }

    public CategoryDTO getCategoryById(int id){
        return categoryRepository.getCategoryById(id);
    }

    public boolean insertCategory(CategoryDTO category) {
        return categoryRepository.insertCategory(category);
    }

    public boolean deleteCategory(CategoryDTO category) {
        return categoryRepository.deleteCategory(category);
    }

    public boolean editCategory(CategoryDTO category) {
        return categoryRepository.editCategory(category);
    }

}
