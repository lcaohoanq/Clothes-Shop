package clothingstore.repository;

import static org.junit.jupiter.api.Assertions.*;

import clothingstore.model.UserDTO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {

    private EntityManagerFactory emf;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        emf = MyEntityManager.getEntityManagerFactory();
        userRepository = new UserRepository(emf);
    }

    @Test
    @Order(1)
    @Transactional
    void saveUser() {
        UserDTO user = new UserDTO("hoang", "luu", "tester@gmail.com", "avatar.jpg", "kebian", "123456", "Hoa Phong, Hoa Vang, Da Nang", "0123456789", 2, true);
        userRepository.saveUser(user);
        UserDTO retrievedUser = userRepository.getUserByUsername(user.getUserName());
        assertNotNull(retrievedUser);
        assertEquals("kebian", retrievedUser.getUserName());
    }


    @Test
    @Order(2)
    void getData() {
        List<UserDTO> users = userRepository.getData();
        assertEquals(1, users.size());
    }

    @Test
    @Order(3)
    void getTotalUsers() {
        int totalUsers = userRepository.getTotalUsers();
        assertEquals(1, totalUsers);
    }

    @Test
    @Order(4)
    void getUserById() {
        UserDTO user = userRepository.getUserById(1);
        assertNotNull(user);
    }

    @Test
    @Order(5)
    void getUserByUsername() {
        UserDTO user = userRepository.getUserByUsername("kebian");
        assertNotNull(user);
    }

    @Test
    @Order(6)
    void getUserByEmail() {
        UserDTO user = userRepository.getUserByEmail("tester@gmail.com");
        assertNotNull(user);
    }

    @Test
    @Order(7)
    void checkUserNameDuplicate() {
        boolean check = userRepository.checkUserNameDuplicate("kebian");
        assertTrue(check);
    }

    @Test
    @Order(8)
    void checkLogin() {
        UserDTO userExist = userRepository.checkLogin("kebian", "123456");
        UserDTO userNotExist = userRepository.checkLogin("kebian", "1234567");
        assertNotNull(userExist);
        assertNull(userNotExist);
    }

    @Test
    @Order(9)
    @Transactional
    void updateUser() {
        UserDTO user = userRepository.getUserById(1);
        user.setFirstName("HOANG");
        userRepository.updateUser(user);
        UserDTO updatedUser = userRepository.getUserById(1);
        assertEquals("HOANG", updatedUser.getFirstName());
    }

    @Test
    @Order(10)
    @Transactional
    void updatePasswordUser() {
        UserDTO user = userRepository.getUserById(1);
        boolean check = userRepository.updatePasswordUser(user, "999999");
        assertTrue(check);
    }


    @Test
    @Order(11)
    @Transactional
    void deleteUser() {
        UserDTO user = new UserDTO("hoang", "luu", "tester@gmail.com", "avatar.jpg", "kebian", "123456", "Hoa Phong, Hoa Vang, Da Nang", "0123456789", 2, true);
        userRepository.saveUser(user);
        userRepository.deleteUser(user.getId());
        UserDTO deletedUser = userRepository.getUserById(2);
        assertNull(deletedUser);
    }
}