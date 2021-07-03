package com.itwn.homework.task0703;

import java.util.Arrays;

public class Task17 {
	public static void main(String[] args) {
		int[] arrs=new int[]{23,45,17,11,13,89,72,26,3,17,11,13};
//		int[] arrs=new int[]{7, 1, 3, 5, 13, 9, 3, 6, 11};
		quickSort(arrs);
		System.out.println(Arrays.toString(arrs));

	}
	public static void quickSort(int[] arr){
		quickSort(arr,0,arr.length-1);
	}

	private static int partition(int[] arr, int left,int right){
		int index=arr[left];
		int i=left;//基准值 同时left 把左指针前移
		left++;
		while (left<right){
			while (arr[left]<index&&left<right){
				left++;
			}
			while (arr[right]>index&&right>=left){		// 防止相同时 right不移动 导致 返回的指针异常
				right--;
			}
			if (left<right){
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		arr[i]=arr[right];
		arr[right]=index;
		return right;
	}



	//递归 根据传入的左右下标 把数组中元素重排序
	private static void quickSort(int[] arr,int left,int right){
		if (left<right){
			int index=partition(arr,left,right);
			quickSort(arr,left,index-1);
			quickSort(arr,index+1,right);
		}

	}
}
