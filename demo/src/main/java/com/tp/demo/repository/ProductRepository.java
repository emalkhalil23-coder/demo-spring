package com.tp.demo.repository;

import com.tp.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // هذا الملف فارغ لأن Spring Boot سيعطيكِ كل عمليات الحفظ والحذف تلقائياً!
}