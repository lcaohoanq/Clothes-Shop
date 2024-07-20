package clothingstore.service;

import clothingstore.model.UserDTO;
import clothingstore.repository.UserRepository;
import java.util.List;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public List<UserDTO> getData(){
        return userRepository.getData();
    }

    public int getTotalUser(){
        return userRepository.getTotalUser();
    }

    public UserDTO getUserById(int id){
        return userRepository.getUserById(id);
    }

    public UserDTO getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        List<UserDTO> list = userService.getData();
        for(UserDTO user : list){
            System.out.println(user);
        }
    }

}
