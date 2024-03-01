package id.ac.ui.cs.advprog.eshop.model;

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
    void testCreatePaymentDefaultStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("cardType", "Visa");
        paymentData.put("amount", "100.00");

        Payment payment = new Payment("123456789", "CreditCard", "Pending", paymentData);

        assertEquals("123456789", payment.getId());
        assertEquals("CreditCard", payment.getMethod());
        assertEquals("Pending", payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
    }

    @Test
    void testCreatePaymentSuccessStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("cardType", "Visa");
        paymentData.put("amount", "100.00");

        Payment payment = new Payment("123456789", "CreditCard", "Success", paymentData);

        assertEquals("Success", payment.getStatus());
    }

    @Test
    void testCreatePaymentInvalidStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("cardType", "Visa");
        paymentData.put("amount", "100.00");

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("123456789", "CreditCard", "InvalidStatus", paymentData);
        });
    }

    @Test
    void testSetStatusToCancelled() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("cardType", "Visa");
        paymentData.put("amount", "100.00");

        Payment payment = new Payment("123456789", "CreditCard", "Pending", paymentData);
        payment.setStatus("Cancelled");

        assertEquals("Cancelled", payment.getStatus());
    }

    @Test
    void testSetStatusWithInvalidData() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("cardType", "Visa");
        paymentData.put("amount", "100.00");

        Payment payment = new Payment("123456789", "CreditCard", "Pending", paymentData);

        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus("InvalidStatus");
        });
    }
}
