package com.itwn.homework.task0703.task15;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Library {
	private static Set<Book> set;
	private static BookDAO bdi;
	static {
		bdi=new BookDAOImpl();
		try {
			//set=new HashSet<>(bdi.findAll());
			List<Book> list=bdi.findAll();
			if (list==null){
				set=new HashSet<>();
			}else {
				set=new HashSet<>(list);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public void queryAll(){
		if (set.isEmpty()){
			System.out.println("图书馆没有查阅书籍");
		}else {
			System.out.println("编号\t书名\t作者\t价格（元）");
			for (Book book:set){
				System.out.println(book);
			}
		}
	}
	public boolean addBook(Book book){
		if (set.contains(book)){
			return false;
		}else {
			try {
				int rows=bdi.add(book);
				if (rows>0){
					set.add(book);
					return true;
				}else {
					return false;
				}
			} catch (SQLException throwables) {
				throwables.printStackTrace();
				return false;
			}
		}

	}
	public boolean delBook(int id){
		try {
			return bdi.deleteById(id) > 0;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}
	}

	public void queryBook(String name){
		String regex="%"+name+"%";
		try {
			List<Book> list=bdi.findLike(regex);
			if (list==null){
				System.out.println("图书馆没有查阅书籍");
			}
			for (Book book:list){
				System.out.println(book.getId()+","+book.getName()+","+book.getAuthor()+","+book.getPrice().toString());
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	public Set<Book> getSet() {
		return set;
	}

	public void setSet(Set<Book> set) {
		this.set = set;
	}

	public BookDAO getBdi() {
		return bdi;
	}

	public void setBdi(BookDAO bdi) {
		this.bdi = bdi;
	}
}
