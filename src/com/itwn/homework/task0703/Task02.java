package com.itwn.homework.task0703;

import jdk.nashorn.internal.ir.CaseNode;

import java.util.Scanner;

public class Task02 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入");
		Integer input=sc.nextInt();
		if (input>90){
			System.out.println("优秀");
		}else if (input>80){
			System.out.println("良好");
		}else if (input>70){
			System.out.println("中等");
		}else if (input>60){
			System.out.println("及格");
		}else{
			System.out.println("不及格");
		}

	}
}
