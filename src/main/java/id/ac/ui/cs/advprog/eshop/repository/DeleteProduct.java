package id.ac.ui.cs.advprog.eshop.repository;


public class DeleteProduct {
    private ProductRepository productRepository;



    public DeleteProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void deleteProduct(String productId) {
        productRepository.productData.removeIf(product -> product.getProductId().equals(productId));
    }
}