package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentRepositoryTest {

    private PaymentRepository paymentRepository;

    @BeforeEach
    public void setUp() {
        paymentRepository = new PaymentRepository();
    }

    @Test
    public void testSaveCreate() {
        Payment payment = new Payment("1", 100.0); // Sample Payment
        Payment savedPayment = paymentRepository.save(payment);

        assertEquals(payment, savedPayment);
        assertEquals(payment, paymentRepository.findById("1"));
    }

    @Test
    public void testSaveUpdate() {
        Payment payment = new Payment("1", 100.0); // Sample Payment
        paymentRepository.save(payment);

        Payment updatedPayment = new Payment("1", 200.0); // Updated Payment
        Payment savedPayment = paymentRepository.save(updatedPayment);

        assertEquals(updatedPayment, savedPayment);
        assertEquals(updatedPayment, paymentRepository.findById("1"));
    }

    @Test
    public void testFindByIdIfFound() {
        Payment payment = new Payment("1", 100.0); // Sample Payment
        paymentRepository.save(payment);

        Payment foundPayment = paymentRepository.findById("1");

        assertNotNull(foundPayment);
        assertEquals(payment.getId(), foundPayment.getId());
    }

    @Test
    public void testFindByIdIfNotFound() {
        Payment payment = paymentRepository.findById("nonexistent_id");

        assertNull(payment);
    }
}