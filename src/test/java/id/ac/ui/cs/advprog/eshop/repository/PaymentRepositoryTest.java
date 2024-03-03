package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    List<Payment> payments;

    @BeforeEach
    public void setUp() {
        paymentRepository = new PaymentRepository();

        payments = new ArrayList<>();
        Payment payment1 = new Payment("1", "voucherCode",
                Map.of("eheheheh", "ESHOP1234567890"));
        payments.add(payment1);
        Payment payment2 = new Payment("2", "BankTransfer",
                Map.of("lololol", "1234567890"));
        payments.add(payment2);
    }

    @Test
    void testSaveCreate() {
        Payment payment = payments.get(1);
        Payment result = paymentRepository.save(payment);

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getPaymentData().keySet(), findResult.getPaymentData().keySet());
        assertEquals(payment.getPaymentData().get("BBNI"),
                findResult.getPaymentData().get("BBNI"));
        assertEquals(payment.getStatus(), findResult.getStatus());
    }

    @Test
    void testSaveUpdate() {
        Payment payment = payments.get(1);
        paymentRepository.save(payment);
        Payment newPayment = new Payment(payment.getId(), payment.getMethod(),
                 OrderStatus.SUCCESS.getValue(), payment.getPaymentData());
        Payment result = paymentRepository.save(newPayment);

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getPaymentData().keySet(), findResult.getPaymentData().keySet());
        assertEquals(payment.getPaymentData().get("BBNI"),
                findResult.getPaymentData().get("BBNI"));
        assertEquals(OrderStatus.SUCCESS.getValue(), findResult.getStatus());
    }

    @Test
    void testFindByIdIfFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payments.get(1).getId(), findResult.getId());
        assertEquals(payments.get(1).getMethod(), findResult.getMethod());
        assertEquals(payments.get(1).getPaymentData().keySet(),
                findResult.getPaymentData().keySet());
        assertEquals(payments.get(1).getPaymentData().get("BRI"),
                findResult.getPaymentData().get("BRI"));
        assertEquals(payments.get(1).getStatus(), findResult.getStatus());
    }

    @Test
    void testFindByIdIfNotFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("hahahah");
        assertNull(findResult);
    }
}