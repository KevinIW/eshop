package id.ac.ui.cs.advprog.eshop.service;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
    @InjectMocks
    PaymentServiceImpl paymentService;
    @Mock
    PaymentRepository paymentRepository;
    List<Payment> payments;

    @BeforeEach
    void setUp() {
        payments = new ArrayList<>();
        Payment payment1 = new Payment("1",  PaymentMethod.VOUCHER_CODE.getValue(),
                Map.of( PaymentMethod.VOUCHER_CODE.getValue(), "ESHOP12345678ABC"));
        payments.add(payment1);
        Payment payment2 = new Payment("2", PaymentMethod.BANK_TRANSFER.getValue(),
                Map.of("BBNI", "69696969696969"));
        payments.add(payment2);
    }

    @Test
    void testCreatePayment() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).save(payment);

        Payment result = paymentService.addPayment(payment);

        verify(paymentRepository, times(1)).save(payment);
        assertEquals(payment.getId(), result.getId());
    }


    @Test
    void testUpdateStatus() {
        Payment payment = payments.get(1);
        Payment newPayment = new Payment(payment.getId(), payment.getMethod(),
                 OrderStatus.SUCCESS.getValue(), payment.getPaymentData());
        doReturn(payment).when(paymentRepository).findById(payment.getId());
        doReturn(newPayment).when(paymentRepository).save(any(Payment.class));

        Payment result = paymentService.setStatus(payment, OrderStatus.SUCCESS.getValue());

        assertEquals(payment.getId(), result.getId());
        assertEquals(OrderStatus.SUCCESS.getValue(), result.getStatus());
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    void testUpdateStatusInvalidStatus() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        assertThrows(IllegalArgumentException.class, () -> {
            paymentService.setStatus(payment, "hiyahiyalol");
        });

        verify(paymentRepository, times(0)).save(any(Payment.class));
    }

    @Test
    void testUpdateStatusInvalidPaymentId() {
        doReturn(null).when(paymentRepository).findById("kesihandehcopas");

        assertThrows(NoSuchElementException.class, () ->
                paymentService.setStatus(new Payment("kesihandehcopas", PaymentMethod.VOUCHER_CODE.getValue(),
                        Map.of(PaymentMethod.VOUCHER_CODE.getValue(), "ESHOP12345678ABC")), OrderStatus.SUCCESS.getValue()));

        verify(paymentRepository, times(0)).save(any(Payment.class));
    }

    @Test
    void testFindByIdIfIdFound() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        Payment result = paymentService.getPayment(payment.getId());
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        doReturn(null).when(paymentRepository).findById("ngakak");
        assertNull(paymentService.getPayment("ngakak"));
    }
}