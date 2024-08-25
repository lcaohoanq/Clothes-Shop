package clothingstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class DatabaseConnection {
    private String url;
    private String user;
    private String password;
}
