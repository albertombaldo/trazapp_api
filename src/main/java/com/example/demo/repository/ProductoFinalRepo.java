package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductoFinal;

@Repository
public interface ProductoFinalRepo extends JpaRepository<ProductoFinal, Long>{

}
