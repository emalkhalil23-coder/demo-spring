package com.tp.demo.service;

import com.tp.demo.model.Product;
import com.tp.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // جلب كل المنتجات
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // حفظ منتج جديد
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}