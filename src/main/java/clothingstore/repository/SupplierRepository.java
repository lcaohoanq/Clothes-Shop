package clothingstore.repository;

import clothingstore.model.SupplierDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SupplierRepository {

    private EntityManagerFactory emf;

    public List<SupplierDTO> getData(){
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT s FROM SupplierDTO s", SupplierDTO.class).getResultList();
        }finally {
            em.close();
        }
    }

    public SupplierDTO getSupplierById(int id){
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(SupplierDTO.class, id);
        }finally {
            em.close();
        }
    }

    public void saveSupplier(SupplierDTO supplier){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(supplier);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = MyEntityManager.getEntityManagerFactory();
        SupplierRepository supplierRepository = new SupplierRepository(emf);
        List<SupplierDTO> supplierList = supplierRepository.getData();
        System.out.println(supplierList.size());
        for (SupplierDTO supplier : supplierList) {
            System.out.println(supplier);
        }
    }

}
