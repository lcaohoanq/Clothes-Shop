package clothingstore.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDTO {

    private int orderID;
    private Date orderDate;
    private double totalPrice;
    private PaymentDTO paymentMethod;
    private UserDTO user;
    private boolean status;

}
