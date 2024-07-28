package clothingstore.impl;

import clothingstore.model.UserDTO;
import clothingstore.repository.MyEntityManager;
import clothingstore.repository.UserRepository;
import clothingstore.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepository(MyEntityManager.getEntityManagerFactory());

    @Override
    public void saveUser(UserDTO user) {
        userRepository.saveUser(user);
    }


    @Override
    public void deleteUser(int userId) {
        userRepository.deleteUser(userId);
    }

    @Override
    public void updateUser(UserDTO user) {
        userRepository.updateUser(user);
    }

    @Override
    public int getTotalUsers() {
        return userRepository.getTotalUsers();
    }

    @Override
    public UserDTO checkLogin(String username, String password) {
        return userRepository.checkLogin(username, password);
    }

    @Override
    public UserDTO getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public boolean checkUserNameDuplicate(String username) {
        return userRepository.checkUserNameDuplicate(username);
    }

    @Override
    public boolean updatePasswordUser(UserDTO user, String newPassword) {
        return userRepository.updatePasswordUser(user, newPassword);
    }

    @Override
    public List<UserDTO> getData() {
        return userRepository.getData();
    }

}
