package com.ecom.product_service.service;

import com.ecom.product_service.entities.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Product product, Long id);

    void deleteProduct(Long id);
}
