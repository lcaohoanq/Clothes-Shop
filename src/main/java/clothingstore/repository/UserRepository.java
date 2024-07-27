package clothingstore.repository;

import clothingstore.model.UserDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import java.util.List;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class UserRepository {

    private final EntityManagerFactory emf;

    public void saveUser(UserDTO user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(user);
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

    public void deleteUser(int userId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            // Find the entity by its ID to ensure it's managed
            UserDTO user = em.find(UserDTO.class, userId);
            if (user != null) {
                em.remove(user);
            }

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


    public void updateUser(UserDTO user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(user);
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

    public int getTotalUsers() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT COUNT(u) FROM UserDTO u WHERE u.status=true AND u.roleID=2", Long.class)
                .getSingleResult().intValue();
        } finally {
            em.close();
        }
    }

    // getSingleResult() throws NoResultException if no result is found
    // can use getResultList() instead to return an empty list
    public UserDTO checkLogin(String username, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT u FROM UserDTO u WHERE (u.userName = :username OR u.email = :username) AND u.password = :password AND u.status=true",
                    UserDTO.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public UserDTO getUserById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(UserDTO.class, id);
        } finally {
            em.close();
        }
    }

    public UserDTO getUserByUsername(String username) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT u FROM UserDTO u WHERE u.userName = :username AND u.status=true",
                    UserDTO.class)
                .setParameter("username", username)
                .getSingleResult();
        } finally {
            em.close();
        }
    }

    public UserDTO getUserByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT u FROM UserDTO u WHERE u.email = :email AND u.status=true", UserDTO.class)
                .setParameter("email", email)
                .getSingleResult();
        } finally {
            em.close();
        }
    }

    public boolean checkUserNameDuplicate(String username) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT COUNT(u) FROM UserDTO u WHERE u.userName = :username AND u.status=true",
                    Long.class)
                .setParameter("username", username)
                .getSingleResult() > 0;
        } finally {
            em.close();
        }
    }

    public boolean updatePasswordUser(UserDTO user, String newPassword) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            user.setPassword(newPassword);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public List<UserDTO> getData() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT u FROM UserDTO u WHERE u.status=true ORDER BY u.roleID ASC", UserDTO.class)
                .getResultList();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = MyEntityManager.getEntityManagerFactory();
        UserRepository userRepository = new UserRepository(emf);
//        UserDTO user = new UserDTO();
        UserDTO user = new UserDTO("hoang", "luu", "tester@gmail.com", "avatar.jpg", "heheheheh",
            "123456", "Hoa Phong, Hoa Vang, Da Nang", "0123456789", 2, true);
//        userRepository.saveUser(user);
//        userRepository.saveUser(user);
//        userRepository.deleteUser(user);
//        userRepository.updateUser(user);
//        userRepository.getTotalUsers();
//        userRepository.checkLogin("username", "password");
//        userRepository.getUserById(1);
        System.out.println(userRepository.getUserByUsername("admin"));
        for (UserDTO u : userRepository.getData()) {
            System.out.println(u);
        }

    }

}
