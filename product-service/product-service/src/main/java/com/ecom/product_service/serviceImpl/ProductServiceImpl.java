package com.ecom.product_service.serviceImpl;

import com.ecom.product_service.entities.Product;
import com.ecom.product_service.exception.ResourceNotFoundException;
import com.ecom.product_service.repository.ProductRepository;
import com.ecom.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: "+id));
    }

    @Override
    public Product updateProduct(Product product, Long id) {

        Product product1 = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: "+id));

        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());

        return productRepository.save(product1);
    }

    @Override
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: "+id));

        productRepository.delete(product);

    }
}
