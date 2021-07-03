package com.itwn.homework.task0703;

public class Task18 {
	public static void main(String[] args) {

		System.out.println(feibonaqi(7));
		System.out.println(jiecheng(5));
	}
	public static int jiecheng(int n){
		if (n==1){
			return 1;
		}
		return n*jiecheng(n-1);
	}

	public static int feibonaqi(int n){
		if (n==1||n==2){
			return 1;
		}
		return feibonaqi(n-1)+feibonaqi(n-2);
	}

}
