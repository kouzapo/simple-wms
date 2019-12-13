package com.example.wmsclient.model;

public class OrderProduct
{
	String id;
	String orderId;
	String productId;
	String quantity;
	String price;
	
	public OrderProduct(String id, String orderId, String productId, String quantity, String price)
	{
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderProduct() 
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

	public String getOrderId() 
	{
		return orderId;
	}

	public void setOrderId(String orderId) 
	{
		this.orderId = orderId;
	}

	public String getProductId() 
	{
		return productId;
	}

	public void setProductId(String productId) 
	{
		this.productId = productId;
	}

	public String getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(String quantity) 
	{
		this.quantity = quantity;
	}

	public String getPrice() 
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}
}