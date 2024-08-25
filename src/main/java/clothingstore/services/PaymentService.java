package clothingstore.services;

import clothingstore.dto.PaymentDTO;
import clothingstore.repositories.BaseEntityManager;
import clothingstore.repositories.PaymentRepository;
import java.util.List;

public class PaymentService implements IPayment {

    private final PaymentRepository paymentRepository = new PaymentRepository(BaseEntityManager.getEntityManagerFactory());

    @Override
    public PaymentDTO getPaymentById(int id) {
        return paymentRepository.getPaymentById(id);
    }

    @Override
    public List<PaymentDTO> getPaymentData() {
        return paymentRepository.getPaymentData();
    }

    @Override
    public void save(PaymentDTO payment) {
        paymentRepository.save(payment);
    }

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        for (PaymentDTO payment : paymentService.getPaymentData()) {
            System.out.println(payment);
        }
    }

}
