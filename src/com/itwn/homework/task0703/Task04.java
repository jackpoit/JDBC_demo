package com.itwn.homework.task0703;

import java.util.Arrays;

public class Task04 {
	public static void main(String[] args) {
		int[] arr={-3,7,18,4,-1};
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length-i; j++) {
				if (arr[j]<arr[j+1]){
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
