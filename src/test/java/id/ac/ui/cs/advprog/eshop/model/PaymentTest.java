package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
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
    void testCreatePaymentSuccessStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("cardType", "Visa");
        paymentData.put("amount", "100.00");

        Payment payment = new Payment("123456789", "CreditCard",OrderStatus.SUCCESS.getValue(), paymentData);

        assertEquals(OrderStatus.SUCCESS.getValue(), payment.getStatus());
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
    void testSetStatusToCANCELLED() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("cardType", "Visa");
        paymentData.put("amount", "100.00");

        Payment payment = new Payment("123456789", "CreditCard",paymentData);
        payment.setStatus("CANCELLED");

        assertEquals("CANCELLED", payment.getStatus());
    }

    @Test
    void testSetStatusWithInvalidData() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("cardType", "Visa");
        paymentData.put("amount", "100.00");

        Payment payment = new Payment("123456789", "CreditCard", paymentData);

        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus("InvalidStatus");
        });
    }
}
