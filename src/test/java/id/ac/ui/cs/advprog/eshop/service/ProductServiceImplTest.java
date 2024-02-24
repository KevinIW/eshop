package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);
        Product createdProduct = productService.create(product);
        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void findAll() {
        List<Product> productList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productList.iterator());
        List<Product> retrievedProducts = productService.findAll();
        assertEquals(productList, retrievedProducts);
        verify(productRepository, times(1)).findAll();
    }


}
