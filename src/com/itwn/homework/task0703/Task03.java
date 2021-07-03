package com.itwn.homework.task0703;

public class Task03 {
	public static void main(String[] args) {
		int num=5;
		int res=0;
		for (int i = 1; i <=num; i+=4) {
			int index=i;
			int mul=1;
			while (index>0){
				mul*=index;
				index--;
			}
			res+=mul;
		}
		System.out.println(res);
	}
}
