package com.itwn.dao;

import com.itwn.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO<E> {
	/**
	 *添加元素
	 * @param e 元素对象
	 * @return 受影响的行数 >0成功
	 */
	int add(E e)throws SQLException;

	/**
	 * 根据id删除元素e
	 * @param id id
	 * @return 受影响的行数 >0成功
	 */
	int deleteById(int id) throws SQLException;

	/**
	 *	根据id来更新
	 * @param e 元素
	 * @return 受影响的行数 >0成功
	 */
	int update(E e) throws SQLException;

	/**
	 * 根据id查询员工记录
	 * @param id 主键
	 * @return 封装后的员工对象
	 */
	E findById(int id) throws SQLException;

	/**
	 *
	 * @return 返回所有元素对象的集合
	 */
	List<E> findAll() throws SQLException;

	/**
	 *
	 * @param str 模糊值
	 * @return 返回查询到的对象的集合
	 */
	List<E> findLike(String str)throws SQLException;
}
