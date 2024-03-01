package id.ac.ui.cs.advprog.eshop.model;
import java.util.Map;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import lombok.*;

@Getter
public class Payment {
    private String id;
    private String method;
    private Map<String, String> paymentData;

    private String status;


    public Payment(String id, String method, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.status = OrderStatus.WAITING_PAYMENT.getValue();

        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }
    }

    public Payment(String id, String method,  String status,Map<String, String> paymentData) {
        this(id, method, paymentData);
        this.setStatus(status);
    }

    public void setStatus(String status) {
        if (OrderStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }
}