package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
	
	public List<Product> findByCategory(String category);

}
