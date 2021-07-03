package com.itwn.homework.task0703.task10;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task12 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("输入：");
		String str=sc.next();
		Map<Character,Integer> map=new TreeMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c=str.charAt(i);
			if (map.containsKey(c)){
				map.put(c,map.get(c)+1);
			}else {
				map.put(c,1);
			}
		}
		System.out.println("字符\t次数");
		for (Map.Entry<Character, Integer> entry:map.entrySet()){
			System.out.println(entry.getKey()+"\t\t"+entry.getValue());
		}
	}
}
