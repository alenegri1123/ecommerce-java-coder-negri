package com.commerce.negri.services;

import com.commerce.negri.entities.Product;
import com.commerce.negri.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired private ProductsRepository repositoryProduct;

    public Product save(Product product) {
        return repositoryProduct.save(product);
    }

    public List<Product> readProduct() {
        return repositoryProduct.findAll();
    }
    
    public Optional<Product> readOne(Long id) {
        return repositoryProduct.findById(id);
    }

    public void deleteOneProd(Long id) {
        repositoryProduct.deleteById(id);
    }


}
