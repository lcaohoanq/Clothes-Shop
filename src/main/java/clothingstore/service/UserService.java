package clothingstore.service;

import clothingstore.model.UserDTO;
import clothingstore.repository.MyEntityManager;
import clothingstore.repository.UserRepository;
import jakarta.persistence.EntityManager;

public class UserService {

    private final UserRepository userRepository = new UserRepository(MyEntityManager.getEntityManagerFactory());

    public void saveUser(UserDTO user) {
        userRepository.saveUser(user);
    }

}
