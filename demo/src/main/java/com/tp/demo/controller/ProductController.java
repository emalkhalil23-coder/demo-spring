package com.tp.demo.controller;

import com.tp.demo.model.Product;
import com.tp.demo.repository.ProductRepository;
import com.tp.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    // فتح الصفحة الرئيسية وعرض جدول المنتجات مباشرة
    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    // جلب المنتجات كـ JSON
    @GetMapping("/api/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // إضافة منتج جديد عبر الـ API
    @PostMapping("/api/products")
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}