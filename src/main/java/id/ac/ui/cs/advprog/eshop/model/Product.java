package id.ac.ui.cs.advprog.eshop.model;


import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
public class Product {
    private Long productId;
    private String productName;
    private int productQuantity;

    // Getter for productId
    public Long getId() {
        return productId;
    }

    // Setter for productId
    public void setId(Long productId) {
        this.productId = productId;
    }


}
