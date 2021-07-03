package com.itwn.homework.task0703;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Task14 {
	public static void main(String[] args) {
		List<Worker> list=new ArrayList<>();
		list.add(new Worker(1,"KK0001","Messi",new Date(1987-1900,6-1,24),new BigDecimal("10000")));
		list.add(new Worker(2,"KK0002","Bolt",new Date(1987-1900,8-1,21),new BigDecimal("5000")));
		list.add(new Worker(3,"KK0003","Neymar",new Date(1992-1900,2-1,5),new BigDecimal("6000")));
		list.add(new Worker(4,"KK0004","LiJiaQi",new Date(1992-1900,6-1,7),new BigDecimal("6000")));
		list.sort((o1,o2)->{
			if (!o1.getBirthday().equals(o2.getBirthday())){
				return o2.getBirthday().compareTo(o1.getBirthday());
			}else {
				if (!o1.getSalary().equals(o2.getSalary())){
					return o1.getSalary().compareTo(o2.getSalary());
				}else {
					return o1.getName().compareTo(o2.getName());
				}
			}
		});
		Iterator<Worker> it=list.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
	}

}
class Worker{
	private Integer id;
	private String wno;
	private String name;
	private Date birthday;
	private BigDecimal salary;


	public Worker() {
	}

	public Worker(Integer id, String wno, String name, Date birthday, BigDecimal salary) {
		this.id = id;
		this.wno = wno;
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWno() {
		return wno;
	}

	public void setWno(String wno) {
		this.wno = wno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
		return "我叫"+name+"，我的工号是"+wno+"，我是" +
				sdf.format(birthday)+"出生，" +
				"今年"+(new Date().getYear()-birthday.getYear())+"岁，" +
				"我的薪资是"+salary+"元";
	}
}
