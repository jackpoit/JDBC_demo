package com.itwn.homework.task0630;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task01 {
	public static void main(String[] args) {
		//1. 集合元素去重
		Map<Emp1, Salary> map=new HashMap<>();
		map.put(new Emp1("jack",1),new Salary(10000,5000));
		map.put(new Emp1("marry",2),new Salary(20000,23000));
		map.put(new Emp1("jack",1),new Salary(10000,5000));
		for (Map.Entry<Emp1,Salary> entry:map.entrySet()){
			System.out.println(entry.getKey()+""+entry.getValue());
		}
		System.out.println();
		Set<Emp2> set=new HashSet<>();
		set.add(new Emp2("jack",2,13311,43435));
		set.add(new Emp2("jack",3,20000,1234));
		set.add(new Emp2("jack",2,13311,43435));
		for (Emp2 emp2:set){
			System.out.println(emp2);
		}

	}
}
class Emp1 {
	private String name;
	private int department;

	public Emp1() {
	}

	public Emp1(String name, int department) {
		this.name = name;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Emp1)) return false;

		Emp1 emp1 = (Emp1) o;

		if (department != emp1.department) return false;
		return name != null ? name.equals(emp1.name) : emp1.name == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + department;
		return result;
	}

	@Override
	public String toString() {
		return "emp1{" +
				"name='" + name + '\'' +
				", department=" + department +
				'}';
	}
}

class Salary {
	private int baseSalary;
	private int ultraSalary;

	public Salary() {
	}

	public Salary(int baseSalary, int ultraSalary) {
		this.baseSalary = baseSalary;
		this.ultraSalary = ultraSalary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Salary)) return false;

		Salary salary = (Salary) o;

		if (baseSalary != salary.baseSalary) return false;
		return ultraSalary == salary.ultraSalary;
	}

	@Override
	public int hashCode() {
		int result = baseSalary;
		result = 31 * result + ultraSalary;
		return result;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	public int getUltraSalary() {
		return ultraSalary;
	}

	public void setUltraSalary(int ultraSalary) {
		this.ultraSalary = ultraSalary;
	}

	@Override
	public String toString() {
		return "salary{" +
				"baseSalary=" + baseSalary +
				", ultraSalary=" + ultraSalary +
				'}';
	}
}
class Emp2{
	private String name;
	private int department;
	private Salary salary;

	public Emp2() {
	}

	public Emp2(String name, int department,int baseSalary,int ultraSalary) {
		this.name = name;
		this.department = department;
		this.salary=new Salary(baseSalary,ultraSalary);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Emp2)) return false;

		Emp2 emp2 = (Emp2) o;

		if (department != emp2.department) return false;
		if (name != null ? !name.equals(emp2.name) : emp2.name != null) return false;
		return salary != null ? salary.equals(emp2.salary) : emp2.salary == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + department;
		result = 31 * result + (salary != null ? salary.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Emp2{" +
				"name='" + name + '\'' +
				", department=" + department +
				", salary=" + salary +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}
}

