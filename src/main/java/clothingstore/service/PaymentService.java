package clothingstore.service;

import clothingstore.model.PaymentDTO;
import clothingstore.utils.TestOnly;
import java.util.List;

public interface PaymentService {
    PaymentDTO getPaymentById(int id);
    List<PaymentDTO> getPaymentData();
    @TestOnly
    void save(PaymentDTO payment);
}