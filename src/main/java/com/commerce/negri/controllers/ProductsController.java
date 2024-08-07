package com.commerce.negri.controllers;

import com.commerce.negri.entities.Product;
import com.commerce.negri.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {

    @Autowired private ProductsService service;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product newProd = service.save(product);
        return new ResponseEntity<>(newProd, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> all = service.findAll():
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
