package clothingstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentDTO {

    private int paymentID;
    private String paymentMethod;

}
