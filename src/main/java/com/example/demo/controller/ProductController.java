package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.request.ProductRequest;
import com.example.demo.service.ProductService;

import jakarta.websocket.server.PathParam;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody ProductRequest product) {
		
		
		return productService.saveProduct(product);
	}
	
	@PostMapping("/addMany")
	public List<Product> addProduct(@RequestBody List<ProductRequest> productList) {
		return productService.saveProducts(productList);
	}
	
	@PatchMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/remove/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
	
	@GetMapping("/get")
	public Product getProduct(@PathParam(value = "id") int id) {
		return productService.getAllProductById(id);
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProduct(@PathParam(value = "category") String category) {
		return productService.getProductByCategory(category);
	}

}
