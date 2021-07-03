package com.itwn.homework.task0703;

import com.alibaba.druid.sql.visitor.functions.Left;

import java.util.Random;

public class ArrayUtil {

	public static void bubbleSort(int[] arr,boolean isDesc){
		if (isDesc){
			for (int i = 1; i < arr.length; i++) {
				for (int j = 0; j < arr.length-i; j++) {
					if (arr[j]<arr[j+1]){
						int temp=arr[j+1];
						arr[j+1]=arr[j];
						arr[j]=temp;
					}
				}
			}
		}else {
			for (int i = 1; i < arr.length; i++) {
				for (int j = 0; j < arr.length-i; j++) {
					if (arr[j]>arr[j+1]){
						int temp=arr[j+1];
						arr[j+1]=arr[j];
						arr[j]=temp;
					}
				}
			}
		}
	}
	public static void bubbleSort(int[] arr){
		bubbleSort(arr,false);
	}


}
