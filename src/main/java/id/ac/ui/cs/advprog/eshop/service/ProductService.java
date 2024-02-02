package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;


public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();




    void deleteById(String id);  // Add method to delete by ID

    void deleteByProductName(String productName);  // Add method to delete by product name
}
