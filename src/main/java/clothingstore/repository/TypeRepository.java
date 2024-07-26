package clothingstore.repository;

import clothingstore.model.TypeDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class TypeRepository {

    private final EntityManagerFactory emf = MyEntityManager.getEntityManagerFactory();

    public TypeDTO getTypeById(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(TypeDTO.class, id);
        }finally {
            em.close();
        }
    }

    public List<TypeDTO> getAllType() {
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT t FROM TypeDTO t", TypeDTO.class).getResultList();
        }finally {
            em.close();
        }
    }

    public void saveType(TypeDTO type) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(type);
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

}
