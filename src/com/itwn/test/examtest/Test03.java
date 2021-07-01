package com.itwn.test.examtest;

public class Test03 {
	public static void main(String[] args) {
	User user1=new User();
	User user2=new User();
	User user3=new User();
	User user4=new User();
	}
}
class  User{
	static int count=0;
	public User(){
		System.out.println(++count+"次数");
	}
}
