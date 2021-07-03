package com.itwn.homework.task0703.task15;

import java.math.BigDecimal;

public class Book {
	private Integer id;
	private String name;
	private String author;
	private BigDecimal price;


	@Override
	public String toString() {
		return id+"\t"+name+"\t"+author+"\t"+price.toString();
	}

	public Book() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Book)) return false;

		Book book = (Book) o;

		if (id != null ? !id.equals(book.id) : book.id != null) return false;
		return name != null ? name.equals(book.name) : book.name == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	public Book(Integer id, String name, String author, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
