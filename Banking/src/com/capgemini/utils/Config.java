package com.capgemini.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.beans.Account;

@Configuration
public class Config
{
	@Bean
	@Qualifier ("map")
	public Map <Integer, Account> map ()
	{
		return new HashMap <Integer, Account> ();
	}
}
