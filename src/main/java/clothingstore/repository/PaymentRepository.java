package clothingstore.repository;

import clothingstore.model.PaymentDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class PaymentRepository {

    private final EntityManagerFactory emf = MyEntityManager.getEntityManagerFactory();

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

}
