package com.itwn.homework.task0703;

import java.util.Arrays;

public class Task05 {
	public static void main(String[] args) {
		double [] arr = {9.6,10.0,8.9,9.8,9.7,9.6,9.2};
		Arrays.sort(arr);
		double sum=0;
		for (int i = 1; i < arr.length-1 ; i++) {
			sum+=arr[i];
		}
		System.out.println(sum/(arr.length-2));
	}
}
