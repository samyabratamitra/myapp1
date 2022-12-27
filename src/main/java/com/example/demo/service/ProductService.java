package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.request.ProductRequest;

@Service
public interface ProductService {

	public Product saveProduct(ProductRequest pdt) ;

	public List<Product> saveProducts(List<ProductRequest> pdt_list);
	
	public List<Product> getAllProducts();
	
	public Product getAllProductById(int p_id) ;
	
	public List<Product> getProductByCategory(String category);
	
	public String deleteProduct(int pid);
	
	public Product updateProduct(Product pdt) ;

	
}
