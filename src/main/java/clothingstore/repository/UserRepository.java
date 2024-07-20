package clothingstore.repository;

import clothingstore.model.UserDTO;
import clothingstore.utils.MyEntityFactory;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class UserRepository {

    private final EntityManagerFactory emf = MyEntityFactory.getInstance();

    public List<UserDTO> getData(){
        try{
            return emf.createEntityManager().createQuery("SELECT u FROM UserDTO u", UserDTO.class).getResultList();
        }finally {
            emf.close();
        }
    }

    public UserDTO getUserById(int id){
        try{
            return emf.createEntityManager().find(UserDTO.class, id);
        }finally {
            emf.close();
        }
    }

    public UserDTO getUserByUsername(String username) {
        try {
            return emf.createEntityManager().find(UserDTO.class, username);
        } finally {
            emf.close();
        }
    }

    public int getTotalUser(){
        try{
            return emf.createEntityManager().createQuery("SELECT COUNT(u) FROM UserDTO u WHERE u.status = true AND u.roleID = 2", Long.class).getSingleResult().intValue();
        }finally {
            emf.close();
        }
    }

    public int updateUser(UserDTO user){
        try{
            emf.createEntityManager().getTransaction().begin();
            emf.createEntityManager().merge(user);
            emf.createEntityManager().getTransaction().commit();
            return 1;
        }catch (Exception e){
            emf.createEntityManager().getTransaction().rollback();
            return 0;
        }finally {
            emf.close();
        }
    }

    public int updatePassword(String username, String password){
        try{
            emf.createEntityManager().getTransaction().begin();
            UserDTO user = emf.createEntityManager().find(UserDTO.class, username);
            user.setPassword(password);
            emf.createEntityManager().merge(user);
            emf.createEntityManager().getTransaction().commit();
            return 1;
        }catch (Exception e){
            emf.createEntityManager().getTransaction().rollback();
            return 0;
        }finally {
            emf.close();
        }
    }

}
