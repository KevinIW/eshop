package id.ac.ui.cs.advprog.eshop.enums;

import lombok.*;

@Getter
public enum OrderStatus {
    WAITING_PAYMENT("WAITING_PAYMENT"),
    FAILED("FAILED"),
    SUCCESS("SUCCESS"),
    CANCELLED("CANCELLED"),
    REJECTED("REJECTED");

    private final String value;
    private OrderStatus(String value) {
        this.value = value;
    }

    public static boolean contains (String param) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.name().equals(param)) {
                return true;
            }
        }
        return false;
    }
}