package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;


public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();

    public boolean updateByName(String productName, Product updatedProduct);


    public boolean deleteByName(String productName);
}
