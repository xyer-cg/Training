package com.cg.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.cg.beans.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Repository
public class ProductRepository
{
	private List <Product> products;
	
	public ProductRepository ()
	{
		try
		{
			BufferedReader reader = new BufferedReader (new InputStreamReader (new ClassPathResource ("products.json").getInputStream ()));
			products = new Gson ().fromJson (reader, new TypeToken <List <Product>> () {}.getType ());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public List <Product> getAllProducts ()
	{
		return products;
	}
}