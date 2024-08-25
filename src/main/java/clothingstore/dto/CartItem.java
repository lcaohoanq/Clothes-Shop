package clothingstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CartItem {

    private ProductDTO product;
    private int quantity;

}
