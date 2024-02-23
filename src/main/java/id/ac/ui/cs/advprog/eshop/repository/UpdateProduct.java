package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Product;

public class UpdateProduct {
    private ProductRepository productRepository;

    public UpdateProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product updateProduct(String productId, Product updateProduct) {
        for (int i = 0; i < productRepository.productData.size(); i++) {
            Product product = productRepository.productData.get(i);
            if (product.getProductId().equals(productId)) {
                product.setProductName(updateProduct.getProductName());
                product.setProductQuantity(updateProduct.getProductQuantity());
                return product;
            }
        }
        return null;
    }
}