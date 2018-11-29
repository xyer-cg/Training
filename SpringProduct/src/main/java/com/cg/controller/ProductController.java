package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.beans.Product;
import com.cg.service.ProductService;

@RestController
public class ProductController
{
	@Autowired
	private ProductService productService;
	
	@CrossOrigin
	@RequestMapping ("/products")
	public List <Product> getAllProducts ()
	{
		return productService.getAllProducts ();
	}
}
