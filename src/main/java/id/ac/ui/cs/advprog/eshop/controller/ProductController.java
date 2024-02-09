package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product,Model model){
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model){
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";

    }

    @GetMapping("/edit")
    public String editProductPage(Model model) {
        // You can use a form or any other means to get the product details for editing
        model.addAttribute("product", new Product());
        return "editProduct";
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product updatedProduct, Model model) {
        boolean updated = service.updateByName(updatedProduct.getProductName(), updatedProduct);
        if (updated) {
            return "redirect:list";
        } else {
            model.addAttribute("error", "Product not found");
            return "editProduct";
        }
    }

    @GetMapping("/delete")
    public String deleteProductPage(Model model) {
        // You can use a form or any other means to get the product name for deletion
        model.addAttribute("productName", "");
        return "deleteProduct";
    }

    @PostMapping("/delete")
    public String deleteProductPost(@RequestParam String productName, Model model) {
        boolean deleted = service.deleteByName(productName);
        if (deleted) {
            return "redirect:list";
        } else {
            model.addAttribute("error", "Product not found");
            return "deleteProduct";
        }
    }
}
