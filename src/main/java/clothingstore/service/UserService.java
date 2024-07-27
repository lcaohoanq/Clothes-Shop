package clothingstore.service;

import clothingstore.model.UserDTO;
import clothingstore.repository.MyEntityManager;
import clothingstore.repository.UserRepository;
import jakarta.persistence.EntityManager;
import java.util.List;

public class UserService {

    private final UserRepository userRepository = new UserRepository(MyEntityManager.getEntityManagerFactory());

    public void saveUser(UserDTO user) {
        userRepository.saveUser(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteUser(userId);
    }

    public void updateUser(UserDTO user) {
        userRepository.updateUser(user);
    }

    public int getTotalUsers() {
        return userRepository.getTotalUsers();
    }

    public UserDTO checkLogin(String username, String password) {
        return userRepository.checkLogin(username, password);
    }

    public UserDTO getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    public UserDTO getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public UserDTO getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public boolean checkUserNameDuplicate(String username) {
        return userRepository.checkUserNameDuplicate(username);
    }

    public boolean updatePasswordUser(UserDTO user, String newPassword){
        return userRepository.updatePasswordUser(user, newPassword);
    }

    public List<UserDTO> getData(){
        return userRepository.getData();
    }

}
