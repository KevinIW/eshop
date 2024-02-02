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
        return "redirect::list";
    }

    @GetMapping("/list")
    public String productListPage(Model model){
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";

    }

    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable Long productId, Model model) {
        Product product = service.findById(productId);

        if (product != null) {
            model.addAttribute("product", product);
            return "editProduct";
        } else {
            // Handle the case where the product with the given ID is not found
            return "redirect:/product/list";
        }
    }

    @PostMapping("/edit/{productId}")
    public String editProductPost(@PathVariable Long productId,
                                  @ModelAttribute Product updatedProduct,
                                  Model model) {
        // Set the ID of the updated product to match the original product
        updatedProduct.setId(productId);

        service.update(updatedProduct);

        return "redirect:/product/list";
    }
}
