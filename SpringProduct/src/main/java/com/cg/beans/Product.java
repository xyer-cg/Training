package com.cg.beans;

public class Product
{
	private int productId;
	private String productName;
	private String productCode;
	private String releaseDate;
	private double price;
	private String description;
	private double starRating;
	private String imageUrl;

	public int getProductId ()
	{
		return productId;
	}

	public void setProductId (int productId)
	{
		this.productId = productId;
	}

	public String getProductName ()
	{
		return productName;
	}

	public void setProductName (String productName)
	{
		this.productName = productName;
	}

	public String getProductCode ()
	{
		return productCode;
	}

	public void setProductCode (String productCode)
	{
		this.productCode = productCode;
	}

	public String getReleaseDate ()
	{
		return releaseDate;
	}

	public void setReleaseDate (String releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public double getPrice ()
	{
		return price;
	}

	public void setPrice (double price)
	{
		this.price = price;
	}

	public String getDescription ()
	{
		return description;
	}

	public void setDescription (String description)
	{
		this.description = description;
	}

	public double getStarRating ()
	{
		return starRating;
	}

	public void setStarRating (double starRating)
	{
		this.starRating = starRating;
	}

	public String getImageUrl ()
	{
		return imageUrl;
	}

	public void setImageUrl (String imageUrl)
	{
		this.imageUrl = imageUrl;
	}
}
