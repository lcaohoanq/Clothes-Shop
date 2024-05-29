package clothingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String avatar;
    private String userName;
    private String password;
    private String address;
    private String phone;
    private int roleID;
    private boolean status;

}
