package com.example.demo.model;

public class Product {
	private Integer ProductID;
	private String ProductName;
	private Integer ProductPrice;
	private Integer ProductAmount;
	private String ProductDetail;


public Product() {
	super();
}

public Product(Integer productID, String productName, Integer productPrice, Integer productAmount,
		String productDetail) {
	super();
	ProductID = ProductID;
	ProductName = ProductName;
	ProductPrice = ProductPrice;
	ProductAmount = ProductAmount;
	ProductDetail = ProductDetail;
}

public Integer getProductID() {
	return ProductID;
}
public void setProductID(Integer productID) {
	ProductID = productID;
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public Integer getProductPrice() {
	return ProductPrice;
}
public void setProductPrice(Integer productPrice) {
	ProductPrice = productPrice;
}
public Integer getProductAmount() {
	return ProductAmount;
}
public void setProductAmount(Integer productAmount) {
	ProductAmount = productAmount;
}
public String getProductDetail() {
	return ProductDetail;
}
public void setProductDetail(String productDetail) {
	ProductDetail = productDetail;
}
}
