package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;


public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();

    Product findById(Long id); // New method for finding a product by ID

    void setId(Product product, Long id); // New method for setting the ID of a product

    Product update(Product product); // New method for updating a product
}
