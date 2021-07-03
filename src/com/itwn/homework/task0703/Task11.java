package com.itwn.homework.task0703;

import java.util.HashSet;
import java.util.Random;

public class Task11 {
	public static void main(String[] args) {
		Random random=new Random();
		HashSet<Integer> set=new HashSet<>();
		while (set.size()<20){
			set.add(random.nextInt(20)+1);
		}
		System.out.println(set);
	}
}
