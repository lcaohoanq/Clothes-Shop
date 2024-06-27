package clothingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemDTO {

    private int quantity;
    private double price;
    private ProductDTO product;
    private int orderID;

}
