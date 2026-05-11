package com.tp.demo.controller;

import com.tp.demo.model.Product;
import com.tp.demo.repository.ProductRepository;
import com.tp.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // تأكدي من أنها Controller وليس RestController
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // هذا السطر هو الأهم لفتح صفحات الـ HTML[span_2](start_span)[span_2](end_span)
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    // هذا هو الجزء الذي ينقصك لفتح الصفحة
    @GetMapping({"/", "/index"})
    public String index(org.springframework.ui.Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/api/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/api/products")
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

}