package com.itwn.homework.task0703;

import java.util.ArrayList;
import java.util.List;

public class Task16 {
	public static void main(String[] args) {
		List<int[]> list=new ArrayList<>();
		int big=1;
		while (big<20) {
			int small=(100-big*5)%3==0?(100-big*5)/3:0;
			if (small!=0){
				int little=100-big-small;
				list.add(new int[]{big,small,little});
			}
			big++;
		}
		System.out.println(list.size());
		System.out.println("大\t中\t小");
		for (int[] e:list){
			System.out.println(e[0]+"\t"+e[1]+"\t"+e[2]);
		}


	}
}
