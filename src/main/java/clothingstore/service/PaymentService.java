package clothingstore.service;

import clothingstore.model.PaymentDTO;
import clothingstore.repository.PaymentRepository;
import java.util.List;

public interface PaymentService {
    PaymentDTO getPaymentById(int id);
    List<PaymentDTO> getPaymentData();
}