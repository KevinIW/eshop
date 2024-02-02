package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Repository
public class ProductRepository {

    private List <Product> productData = new ArrayList<>();

    public Product create (Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public boolean updateByName(String productName, Product updatedProduct) {
        ListIterator<Product> iterator = productData.listIterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(productName)) {
                iterator.set(updatedProduct);
                return true; // Product updated successfully
            }
        }
        return false; // Product not found
    }
}
