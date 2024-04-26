package com.example.Prefinals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @PutMapping("/{id}")
    public void editProduct(@PathVariable("id") int productId, @RequestBody Product updatedProduct) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
        existingProduct.setProductPrice(updatedProduct.getProductPrice());
        existingProduct.setProductType(updatedProduct.getProductType());
        productRepository.save(existingProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") int productId) {
        productRepository.deleteById(productId);
    }
}
