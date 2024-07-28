package clothingstore.repository;

import clothingstore.model.PaymentDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentRepository {

    private final EntityManagerFactory emf;

    public PaymentDTO getPaymentById(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(PaymentDTO.class, id);
        }finally {
            em.close();
        }
    }

    public List<PaymentDTO> getPaymentData(){
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT p FROM PaymentDTO p", PaymentDTO.class).getResultList();
        }finally {
            em.close();
        }
    }

    public void save(PaymentDTO payment) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(payment);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

}
