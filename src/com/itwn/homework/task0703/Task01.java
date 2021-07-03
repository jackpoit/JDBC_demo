package com.itwn.homework.task0703;

public class Task01 {
	public static void main(String[] args) {
//		1、已知a,b,c的值分别是100,200,300，请写出程序输出最大值和最小值
		int a=100;
		int b=200;
		int c=50;
		int min;
		int max;
		if (a>=b){
			max=a;
			min=b;
		}else {
			max=b;
			min=a;
		}
		if (c>max){
			max=c;
		}
		if (c<min){
			min=c;
		}
		System.out.println(min+"\n"+max);
	}
}
