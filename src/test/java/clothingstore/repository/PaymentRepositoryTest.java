package clothingstore.repository;

import static org.junit.jupiter.api.Assertions.*;

import clothingstore.model.PaymentDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class PaymentRepositoryTest {

    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository(MyEntityManager.getEntityManagerFactory());
    }

    @Test
    @Order(1)
    @Transactional
    void save(){
        PaymentDTO payment = new PaymentDTO("Test Payment");

        paymentRepository.save(payment);

        PaymentDTO retrievedPayment = paymentRepository.getPaymentById(payment.getPaymentID());

        assertNotNull(retrievedPayment);
        assertEquals("Test Payment", retrievedPayment.getPaymentMethod());
    }

    @Test
    void getPaymentById() {
        PaymentDTO payment = paymentRepository.getPaymentById(1);
        assertNotNull(payment);
    }

    @Test
    void getPaymentData() {
        assertNotNull(paymentRepository.getPaymentData());
        assertEquals(1, paymentRepository.getPaymentData().size());
    }
}