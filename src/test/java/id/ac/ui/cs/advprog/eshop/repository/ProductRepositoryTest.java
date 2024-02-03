package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {


    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp(){

    }

    @Test
    void testCreateAndFine(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());


    }

    @Test
    void testFindAllEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());

    }

    @Test
    void testFindAllIfMoreThanOneProduct(){

        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());

    }

    @Test
    void testEdit() {
        // Create a product
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        // Modify the product
        Product updatedProduct = new Product();
        updatedProduct.setProductName("Sampo Cap Updated");
        updatedProduct.setProductQuantity(200);

        // Edit the product
        boolean updated = productRepository.updateByName("Sampo Cap Bambang", updatedProduct);
        assertTrue(updated);

        // Find and check the edited product
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product editedProduct = productIterator.next();
        assertEquals(updatedProduct.getProductName(), editedProduct.getProductName());
        assertEquals(updatedProduct.getProductQuantity(), editedProduct.getProductQuantity());

        // Negative Scenario: Try to edit a non-existing product
        Product nonExistingProduct = new Product();
        nonExistingProduct.setProductName("Non-Existing Product");
        nonExistingProduct.setProductQuantity(50);
        boolean nonExistingUpdated = productRepository.updateByName("Non-Existing Product", nonExistingProduct);
        assertFalse(nonExistingUpdated);
    }

    @Test
    void testDelete() {
        // Create a product
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        // Delete the product
        boolean deleted = productRepository.deleteByName("Sampo Cap Bambang");
        assertTrue(deleted);

        // Check that the product is no longer in the repository
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());

        // Negative Scenario: Try to delete a non-existing product
        boolean nonExistingDeleted = productRepository.deleteByName("Non-Existing Product");
        assertFalse(nonExistingDeleted);
    }



}
