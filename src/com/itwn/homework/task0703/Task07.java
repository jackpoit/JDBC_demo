package com.itwn.homework.task0703;

import javax.sound.sampled.Line;

public class Task07 {
	public static void main(String[] args) {

		new Employee("WNSH1001","张三",0,28,new Department("IT研发部","1","007")).info();
	}
	static class Employee{
		private String id;
		private String name;
		private Integer gender; //0:男 1：女
		private Integer age;
		Department department;

		public void info(){
			System.out.println("工号"+this.getId()+
					"的"+this.getName()+"，今年"+this.getAge()+
					"岁，性别"+(this.getGender().equals(0)?"男":"女")+"。所在任职部门为"+this.getDepartment().getdName()+"，" +
					"部门编号为"+this.getDepartment().getId());
		}

		public Employee() {
		}

		public Employee(String id, String name, Integer gender, Integer age, Department department) {
			this.id = id;
			this.name = name;
			this.gender = gender;
			this.age = age;
			this.department = department;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getGender() {
			return gender;
		}

		public void setGender(Integer gender) {
			this.gender = gender;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}
	}
	static class Department{
		private String dName;
		private String area;
		private String id;

		public Department() {
		}

		public Department(String dName, String area, String id) {
			this.dName = dName;
			this.area = area;
			this.id = id;
		}

		public String getdName() {
			return dName;
		}

		public void setdName(String dName) {
			this.dName = dName;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}

}
