package clothingstore.repository;

import clothingstore.model.TypeDTO;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class TypeRepository {

    private final EntityManagerFactory emf = MyEntityManager.getEntityManagerFactory();

    public TypeDTO getTypeById(int id) {
        try{
            return emf.createEntityManager().find(TypeDTO.class, id);
        }finally {
            emf.close();
        }
    }

    public List<TypeDTO> getAllType() {
        try{
            return emf.createEntityManager().createQuery("SELECT t FROM TypeDTO t", TypeDTO.class).getResultList();
        }finally {
            emf.close();
        }
    }

}
