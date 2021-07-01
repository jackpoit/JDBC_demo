package com.itwn.homework.task0630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task02 {
	public static void main(String[] args) {
		//2. 集合元素删除某个元素  （a a a b c d,  删除所有的a ）
		String[] strs={"a","b","a","a","a","c","d"};
		List<String> list=new ArrayList<>(Arrays.asList(strs));
		while (list.contains("a")){
			list.remove("a");
		}
		System.out.println(list);
	}
}

