package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Utiliza;

@Repository
public interface UtilizaRepo extends JpaRepository<Utiliza, Long>{

}
