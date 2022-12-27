package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;
import com.example.demo.request.ProductRequest;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo repository;
	
	public Product saveProduct(ProductRequest product) {
		Product pdt = new Product();
		pdt.setCategory(product.getCategory());
		pdt.setPdtName(product.getPdtName());
		pdt.setPrice(product.getPrice());
		pdt.setQty(product.getQty());
		
		return repository.save(pdt);
	}

	public List<Product> saveProducts(List<ProductRequest> pdt_list) {
		
		List<Product> product_list = new ArrayList<Product>();
		pdt_list.stream().forEach(product ->{
			Product pdt = new Product();
			pdt.setCategory(product.getCategory());
			pdt.setPdtName(product.getPdtName());
			pdt.setPrice(product.getPrice());
			pdt.setQty(product.getQty());
			
			product_list.add(pdt);
			
		});
		return repository.saveAll(product_list);
	}
	
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
	
	public Product getAllProductById(int p_id) {
		return repository.findById(p_id).orElse(null);
	}
	
	public List<Product> getProductByCategory(String category) {
		if(category == null || category.isEmpty()) {
			return repository.findAll();
		}
		return repository.findByCategory(category);
	}
	
	public String deleteProduct(int pid) {
		 
		try{
			repository.deleteById(pid);
		}catch(Exception e) {
			return e+"Exception Occured. Item not deleted/found in Database";
		}
		 return pid+" deleted";
	}
	
	public Product updateProduct(Product pdt) {
		
		Product existing_pdt = repository.findById(pdt.getPid()).orElse(null);
		
		if(existing_pdt!= null) {
			existing_pdt.setCategory(pdt.getCategory());
			existing_pdt.setPdtName(pdt.getPdtName());
			existing_pdt.setPrice(pdt.getPrice());
			existing_pdt.setQty(pdt.getQty());
		}
		
		return repository.save(existing_pdt);

	}


}

	