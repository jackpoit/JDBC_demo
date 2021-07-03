package com.itwn.homework.task0703.task15;

import com.itwn.utils.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
	@Override
	public int add(Book book) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO t_books value(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, book.getId());
		ps.setObject(2, book.getName());
		ps.setObject(3, book.getAuthor());
		ps.setObject(4, book.getPrice());
		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public int deleteById(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "DELETE FROM t_books WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, id);
		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public int update(Book book) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE t_books SET name=?,author=?,price=? WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, book.getName());
		ps.setObject(2, book.getAuthor());
		ps.setObject(3, book.getPrice());
		ps.setObject(4, book.getId());
		int rows = ps.executeUpdate();
		DBUtil.release(conn, ps);
		return rows;
	}

	@Override
	public Book findById(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,name,author,price FROM t_books WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, id);
		ResultSet rs = ps.executeQuery();
		Book book = null;
		while (rs.next()) {
			Integer ids = rs.getInt("id");
			String name = rs.getString("name");
			String author = rs.getString("author");
			BigDecimal price = rs.getBigDecimal("price");
			book = new Book(ids, name, author, price);
		}
		DBUtil.release(conn, ps);
		return book;
	}

	@Override
	public List<Book> findAll() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,name,author,price FROM t_books ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Book book = null;
		List<Book> list = new ArrayList<>();
		while (rs.next()) {
			Integer ids = rs.getInt("id");
			String name = rs.getString("name");
			String author = rs.getString("author");
			BigDecimal price = rs.getBigDecimal("price");
			book = new Book(ids, name, author, price);
			list.add(book);
		}
		DBUtil.release(conn, ps);
		return list.isEmpty() ? null : list;
	}

	@Override
	public List<Book> findLike(String str) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT id,name,author,price FROM t_books WHERE name Like ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1,str);
		ResultSet rs = ps.executeQuery();
		Book book = null;
		List<Book> list = new ArrayList<>();
		while (rs.next()) {
			Integer ids = rs.getInt("id");
			String name = rs.getString("name");
			String author = rs.getString("author");
			BigDecimal price = rs.getBigDecimal("price");
			book = new Book(ids, name, author, price);
			list.add(book);
		}
		DBUtil.release(conn, ps);
		return list.isEmpty() ? null : list;
	}
}
