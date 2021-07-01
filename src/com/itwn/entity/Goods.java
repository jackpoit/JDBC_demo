package com.itwn.entity;

import java.math.BigDecimal;

public class Goods {
	private Integer id;
	private String pName;
	private String description;
	private BigDecimal price;
	private Integer stock;
	private Integer sales;

	public Goods(String pName, String description, BigDecimal price, Integer stock, Integer sales) {
		this.pName = pName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.sales = sales;
	}

	public Goods(Integer id, String pName, String description, BigDecimal price, Integer stock, Integer sales) {
		this.id = id;
		this.pName = pName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.sales = sales;
	}

	public Goods() {
	}

	@Override
	public String toString() {
		return "Goods{" +
				"id=" + id +
				", pName='" + pName + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", stock=" + stock +
				", sales=" + sales +
				'}'+"\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}
}
