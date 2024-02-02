package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;




import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private List<Product> productData = new ArrayList<>();
    private long nextId = 1;

    public Product create(Product product) {
        product.setId(nextId++);
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Optional<Product> findById(Long id) {
        return productData.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public Product save(Product updatedProduct) {
        Optional<Product> existingProduct = findById(updatedProduct.getId());

        if (existingProduct.isPresent()) {
            int index = productData.indexOf(existingProduct.get());
            productData.set(index, updatedProduct);
            return updatedProduct;
        } else {
            // If the product with the given ID doesn't exist, you may choose to throw an exception or handle it accordingly.
            // Here, we'll just return null for simplicity.
            return null;
        }
    }
}