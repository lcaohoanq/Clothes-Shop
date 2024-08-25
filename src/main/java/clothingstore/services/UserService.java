package clothingstore.services;

import clothingstore.dto.UserDTO;
import clothingstore.repositories.BaseEntityManager;
import clothingstore.repositories.UserRepository;
import java.util.List;

public class UserService implements IUser {
    private final UserRepository userRepository = new UserRepository(BaseEntityManager.getEntityManagerFactory());

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

    public static void main(String[] args) {
        IUser IUser = new UserService();
        List<UserDTO> list = IUser.getData();
        for (UserDTO userDTO : list) {
            System.out.println(userDTO);
        }
    }

}
