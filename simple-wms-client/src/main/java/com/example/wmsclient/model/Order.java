package com.example.wmsclient.model;

public class Order 
{
	private String id;
	private String state;
	private String customerId;
	
	public Order(String id, String state, String customerId) 
	{
		this.id = id;
		this.state = state;
		this.customerId = customerId;
	}
	
	public Order(String state)
	{
		this.state = state;
	}
	
	public Order()
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

	public String getState() 
	{
		return state;
	}

	public void setState(String state) 
	{
		this.state = state;
	}

	public String getCustomerId() 
	{
		return customerId;
	}

	public void setCustomerId(String customerId) 
	{
		this.customerId = customerId;
	}
}