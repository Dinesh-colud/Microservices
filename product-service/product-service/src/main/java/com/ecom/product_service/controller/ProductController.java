package com.ecom.product_service.controller;

import com.ecom.product_service.entities.Product;
import com.ecom.product_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,
                                                 @PathVariable Long id){

        return new ResponseEntity<>(productService.updateProduct(product, id),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully!");
    }

}
