package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Product;
import com.cg.repository.ProductRepository;

@Service
public class ProductService
{
	@Autowired
	private ProductRepository productRepository;
	
	public List <Product> getAllProducts ()
	{
		return productRepository.getAllProducts ();
	}
}
