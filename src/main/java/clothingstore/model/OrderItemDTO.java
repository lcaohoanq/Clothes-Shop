package clothingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private int orderID;
    private int quantity;
    private double price;
    private ProductDTO product;

    public OrderItemDTO(int orderID, int quantity, double price){
        this.orderID = orderID;
        this.quantity = quantity;
        this.price = price;
    }

}
