package clothingstore.repository;

import clothingstore.model.CategoryDTO;
import clothingstore.model.UserDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryRepository {

   private EntityManagerFactory emf;

   public List<CategoryDTO> getData(){
         return emf.createEntityManager().createQuery("SELECT c FROM CategoryDTO c").getResultList();
   }

    public void saveCategory(CategoryDTO category) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

   public CategoryDTO getCategoryById(int id){
       return emf.createEntityManager().find(CategoryDTO.class, id);
   }

   public boolean insertCategory(CategoryDTO category) {
       try {
           emf.createEntityManager().getTransaction().begin();
           emf.createEntityManager().persist(category);
           emf.createEntityManager().getTransaction().commit();
           return true;
       } catch (Exception e) {
           if (emf.createEntityManager().getTransaction().isActive()) {
               emf.createEntityManager().getTransaction().rollback();
           }
           return false;
       }
   }

   public boolean deleteCategory(CategoryDTO category) {
       try {
           emf.createEntityManager().getTransaction().begin();
           emf.createEntityManager().remove(category);
           emf.createEntityManager().getTransaction().commit();
           return true;
       } catch (Exception e) {
           if (emf.createEntityManager().getTransaction().isActive()) {
               emf.createEntityManager().getTransaction().rollback();
           }
           return false;
       }
   }

   public boolean editCategory(CategoryDTO category) {
       try {
           emf.createEntityManager().getTransaction().begin();
           emf.createEntityManager().merge(category);
           emf.createEntityManager().getTransaction().commit();
           return true;
       } catch (Exception e) {
           if (emf.createEntityManager().getTransaction().isActive()) {
               emf.createEntityManager().getTransaction().rollback();
           }
           return false;
       }
   }

    public static void main(String[] args) {
        CategoryRepository cr = new CategoryRepository(Persistence.createEntityManagerFactory("ClothesShop"));
        List<CategoryDTO> list = cr.getData();
        System.out.println("Size: " + list.size());
        for(CategoryDTO c : list){
            System.out.println(c);
        }

        CategoryDTO category = cr.getCategoryById(9);
        System.out.println(category);

    }

}
