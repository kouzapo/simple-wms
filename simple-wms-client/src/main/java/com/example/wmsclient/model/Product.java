package com.example.wmsclient.model;

public class Product 
{
	private String id;
	private String name;
	private String quality;
	private String packaging;
	private int stock;
	
	public Product(String id, String name, String quality, String packaging, int stock) 
	{
		this.id = id;
		this.name = name;
		this.quality = quality;
		this.packaging = packaging;
		this.stock = stock;
	}
	
	public Product(String name, String quality, String packaging, int stock) 
	{
		this.name = name;
		this.quality = quality;
		this.packaging = packaging;
		this.stock = stock;
	}

	public Product()
	{
		
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getQuality() 
	{
		return quality;
	}

	public void setQuality(String quality) 
	{
		this.quality = quality;
	}

	public String getPackaging() 
	{
		return packaging;
	}

	public void setPackaging(String packaging) 
	{
		this.packaging = packaging;
	}

	public int getStock() 
	{
		return stock;
	}

	public void setStock(int stock) 
	{
		this.stock = stock;
	}
}