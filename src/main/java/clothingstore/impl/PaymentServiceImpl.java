package clothingstore.impl;

import clothingstore.model.PaymentDTO;
import clothingstore.repository.MyEntityManager;
import clothingstore.repository.PaymentRepository;
import clothingstore.service.PaymentService;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository = new PaymentRepository(MyEntityManager.getEntityManagerFactory());

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
        PaymentServiceImpl paymentService = new PaymentServiceImpl();
        for (PaymentDTO payment : paymentService.getPaymentData()) {
            System.out.println(payment);
        }
    }

}
