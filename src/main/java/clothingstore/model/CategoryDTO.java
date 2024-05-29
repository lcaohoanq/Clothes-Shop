package clothingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDTO {

    private int id;
    private String name;
    private TypeDTO type;

}
