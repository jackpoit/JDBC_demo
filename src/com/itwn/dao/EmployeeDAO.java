package com.itwn.dao;

import com.itwn.entity.Employee;


/**
 * 员工 Employee 的持久层接口
 * 目的：给员工操作数据库提供一整套完整的CRUD API规范
 *	API(application programming interface)
 */
public interface EmployeeDAO extends GeneralDAO<Employee> {

}
