package com.commerce.negri.services;

import com.commerce.negri.entities.Product;
import com.commerce.negri.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public Product createProduct(Product product) {
        return productsRepository.save(product);
    }

    public List<Product> getAllProducts() {
        List<Product> products = productsRepository.findAll();
        if (products.isEmpty()) {
            throw new RuntimeException("Products not found");
        } else {
            return products;
        }
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productsRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RuntimeException("Product not found");
        }

    }

    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> product = productsRepository.findById(id);
        if (product.isPresent()) {
            Product foundProduct = product.get();
            if (productDetails.getTitle() != null) {
                foundProduct.setTitle(productDetails.getTitle());
            }
            if (productDetails.getStock() != null) {
                foundProduct.setStock(productDetails.getStock());
            }
            if (productDetails.getPrice() != null) {
                foundProduct.setPrice(productDetails.getPrice());
            }
            return productsRepository.save(foundProduct);
        } else {
            throw new RuntimeException("Product not found");
        }

    }
}
