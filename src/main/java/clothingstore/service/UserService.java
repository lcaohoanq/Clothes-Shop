package clothingstore.service;

import clothingstore.model.UserDTO;
import java.util.List;

public interface UserService {
    void saveUser(UserDTO user);
    void deleteUser(int userId);
    void updateUser(UserDTO user);
    int getTotalUsers();
    UserDTO checkLogin(String username, String password);
    UserDTO getUserById(int userId);
    UserDTO getUserByUsername(String username);
    UserDTO getUserByEmail(String email);
    boolean checkUserNameDuplicate(String username);
    boolean updatePasswordUser(UserDTO user, String newPassword);
    List <UserDTO> getData();
}
