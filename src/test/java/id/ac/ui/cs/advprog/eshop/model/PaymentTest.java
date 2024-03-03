package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentTest {
    @Test
    void testCreateEmptyPayment() {
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("", "", "", new HashMap<>());
        });
    }


    @Test
    public void testCreatePayment() {
        Payment payment = new Payment("1", PaymentMethod.VOUCHER_CODE.getValue(), Map.of(PaymentMethod.VOUCHER_CODE.getValue(), "ESHOP12345678ABC"));
        assertEquals("1", payment.getId());
        assertEquals(PaymentMethod.VOUCHER_CODE.getValue(), payment.getMethod());
        assertEquals(Map.of(PaymentMethod.VOUCHER_CODE.getValue(), "ESHOP12345678ABC"), payment.getPaymentData());
        assertEquals(OrderStatus.WAITING_PAYMENT.getValue(), payment.getStatus());
    }
    @Test
    void testCreatePaymentSuccessStatus() {
        Payment payment = new Payment("1", PaymentMethod.VOUCHER_CODE.getValue(),  OrderStatus.SUCCESS.getValue(), Map.of(PaymentMethod.VOUCHER_CODE.getValue(), "ESHOP12345678ABC"));
        assertEquals("1", payment.getId());
        assertEquals(PaymentMethod.VOUCHER_CODE.getValue(), payment.getMethod());
        assertEquals(Map.of(PaymentMethod.VOUCHER_CODE.getValue(), "ESHOP12345678ABC"), payment.getPaymentData());
        assertEquals(OrderStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentInvalidStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put(PaymentMethod.VOUCHER_CODE.getValue(), "ESHOP12345678ABC");


        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("123456789", PaymentMethod.VOUCHER_CODE.getValue(), "InvalidStatus", paymentData);
        });
    }

    @Test
    void testSetStatusToSuccess() {
        Payment payment = new Payment("1", PaymentMethod.VOUCHER_CODE.getValue(), Map.of(PaymentMethod.VOUCHER_CODE.getValue(), "ESHOP12345678ABC"));
        payment.setStatus(OrderStatus.SUCCESS.getValue());
        assertEquals(OrderStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testSetStatusToReject() {
        Payment payment = new Payment("1", PaymentMethod.VOUCHER_CODE.getValue(), Map.of(PaymentMethod.VOUCHER_CODE.getValue(), "ESHOP12345678ABC"));
        payment.setStatus(OrderStatus.REJECTED.getValue());
        assertEquals(OrderStatus.REJECTED.getValue(), payment.getStatus());
    }


    @Test
    void testSetInvalidStatus() {
        Payment payment = new Payment("1", PaymentMethod.VOUCHER_CODE.getValue(), Map.of(PaymentMethod.VOUCHER_CODE.getValue(), "ESHOP12345678ABC"));
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("INVALID_STATUS"));
    }

    @Test
    void testSetStatusWithEmptyPaymentData() {
        assertThrows(IllegalArgumentException.class, () -> new Payment("1", PaymentMethod.VOUCHER_CODE.getValue(), new HashMap<>()));
    }
}
