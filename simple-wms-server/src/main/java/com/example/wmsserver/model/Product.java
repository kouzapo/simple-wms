package com.example.wmsserver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Apostolos Kouzoukos
 */
@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class Product implements Serializable
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	@Size(max = 30)
    private String name;
	
	@NotBlank
	@Size(max = 2)
	private String quality;
	
	@NotBlank
	@Size(max = 2)
	private String packaging;
	
	@NotNull
	Long stock;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
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

	public Long getStock() 
	{
		return stock;
	}

	public void setStock(Long stock) 
	{
		this.stock = stock;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() 
	{
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) 
	{
		this.updatedAt = updatedAt;
	}
}