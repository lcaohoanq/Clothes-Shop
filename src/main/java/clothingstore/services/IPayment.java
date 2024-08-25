package clothingstore.services;

import clothingstore.dto.PaymentDTO;
import clothingstore.utils.TestOnly;
import java.util.List;

public interface IPayment {
    PaymentDTO getPaymentById(int id);
    List<PaymentDTO> getPaymentData();
    @TestOnly
    void save(PaymentDTO payment);
}