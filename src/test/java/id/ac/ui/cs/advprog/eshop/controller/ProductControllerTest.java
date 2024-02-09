package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProductPage() {
        String viewName = productController.createProductPage(model);
        assertEquals("createProduct", viewName);
    }

    @Test
    void createProductPost() {
        Product product = new Product();
        String viewName = productController.createProductPost(product, model);
        assertEquals("redirect:list", viewName);
        verify(productService, times(1)).create(product);
    }

    @Test
    void productListPage() {
        List<Product> products = new ArrayList<>();
        when(productService.findAll()).thenReturn(products);
        String viewName = productController.productListPage(model);
        assertEquals("productList", viewName);
        verify(model, times(1)).addAttribute("products", products);
    }

    @Test
    void editProductPage() {
        String viewName = productController.editProductPage(model);
        assertEquals("editProduct", viewName);
    }

    @Test
    void editProductPost() {
        Product product = new Product();
        when(productService.updateByName(product.getProductName(), product)).thenReturn(true);
        String viewName = productController.editProductPost(product, model);
        assertEquals("redirect:list", viewName);
        verify(productService, times(1)).updateByName(product.getProductName(), product);

        when(productService.updateByName(product.getProductName(), product)).thenReturn(false);
        viewName = productController.editProductPost(product, model);
        assertEquals("editProduct", viewName);
        verify(model, times(1)).addAttribute("error", "Product not found");
    }

    @Test
    void deleteProductPage() {
        String viewName = productController.deleteProductPage(model);
        assertEquals("deleteProduct", viewName);
    }

    @Test
    void deleteProductPost() {
        String productName = "TestProduct";
        when(productService.deleteByName(productName)).thenReturn(true);
        String viewName = productController.deleteProductPost(productName, model);
        assertEquals("redirect:list", viewName);
        verify(productService, times(1)).deleteByName(productName);

        when(productService.deleteByName(productName)).thenReturn(false);
        viewName = productController.deleteProductPost(productName, model);
        assertEquals("deleteProduct", viewName);
        verify(model, times(1)).addAttribute("error", "Product not found");
    }
}
