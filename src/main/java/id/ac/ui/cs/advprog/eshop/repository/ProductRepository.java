package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Repository
public class ProductRepository {

    List <Product> productData = new ArrayList<>();

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

    public boolean deleteByName(String productName) {
        Iterator<Product> iterator = productData.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(productName)) {
                iterator.remove();
                return true; // Product deleted successfully
            }
        }
        return false; // Product not found
    }

    public Product findById(String id) {
        for (Product product : productData) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public Product update (String id, Product updateProduct) {
        UpdateProduct update = new UpdateProduct(this);
        return update.updateProduct(id, updateProduct);
    }

    public void delete (String id) {
        DeleteProduct deleteProduct = new DeleteProduct(this);
        deleteProduct.deleteProduct(id);
    }

}
