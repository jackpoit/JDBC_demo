package com.itwn.homework.task0703;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilTest {

	@Test
	void bubbleSort() {
		int[] arr={-3,7,18,4,-1};
		ArrayUtil.bubbleSort(arr,true);
		System.out.println(Arrays.toString(arr));
		ArrayUtil.bubbleSort(arr,false);
		System.out.println(Arrays.toString(arr));
	}
}