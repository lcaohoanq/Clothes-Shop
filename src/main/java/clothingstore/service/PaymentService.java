package clothingstore.service;

import clothingstore.model.PaymentDTO;
import clothingstore.repository.PaymentRepository;
import java.util.List;

public class PaymentService {
    private final PaymentRepository paymentRepository = new PaymentRepository();

    public PaymentDTO getPaymentById(int id) {
        return paymentRepository.getPaymentById(id);
    }

    public List<PaymentDTO> getPaymentData() {
        return paymentRepository.getPaymentData();
    }

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        for(PaymentDTO payment : paymentService.getPaymentData()) {
            System.out.println(payment);
        }
    }

}