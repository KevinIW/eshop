package id.ac.ui.cs.advprog.eshop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import  id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import java.util.*;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        if (method.equals(PaymentMethod.VOUCHER_CODE.getValue())) {
            String voucherCode = paymentData.get("voucherCode");
            if (voucherCode != null && voucherCode.length() == 16 &&
                    voucherCode.startsWith("ESHOP") &&
                    voucherCode.substring(5).chars().filter(Character::isDigit).count() == 8
            ) {
                // Valid voucher code, proceed with payment
                Payment payment = new Payment(
                        String.valueOf(paymentRepository.findAll().size() + 1),
                        method,
                        OrderStatus.SUCCESS.getValue(),
                        paymentData
                );
                paymentRepository.save(payment);
                return payment;
            } else {
                // Invalid voucher code, reject payment
                Payment payment = new Payment(
                        String.valueOf(paymentRepository.findAll().size() + 1),
                        method,
                        OrderStatus.REJECTED.getValue(),
                        paymentData
                );
                paymentRepository.save(payment);
                return payment;
            }
        } else if (method.equals(PaymentMethod.BANK_TRANSFER.getValue())) {
            // Check if all bank transfer information is provided
                if (!paymentData.isEmpty() &&
                        !paymentData.keySet().isEmpty() &&
                        !paymentData.values().isEmpty() &&
                        !paymentData.containsKey(null) &&
                        !paymentData.containsValue(null)) {
                // All information provided, proceed with payment
                Payment payment = new Payment(
                        String.valueOf(paymentRepository.findAll().size() + 1),
                        method,
                        OrderStatus.SUCCESS.getValue(),
                        paymentData
                );
                paymentRepository.save(payment);
                return payment;
            } else {
                // Missing bank transfer information, reject payment
                Payment payment = new Payment(
                        String.valueOf(paymentRepository.findAll().size() + 1),
                        method,
                        OrderStatus.REJECTED.getValue(),
                        paymentData
                );
                paymentRepository.save(payment);
                return payment;
            }
        }
        return null;
    }





    @Override
    public Payment addPayment(Payment payment) {
        paymentRepository.save(payment);
        return payment;
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        Payment result = paymentRepository.findById(payment.getId());
        if (result != null) {
            Payment newPayment = new Payment(payment.getId(), payment.getMethod(),  status, payment.getPaymentData());
            paymentRepository.save(newPayment);
            return newPayment;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Payment getPayment(String id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }
}