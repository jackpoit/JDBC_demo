package com.itwn.test.examtest;

import java.util.HashMap;
import java.util.Map;

public class Test01 {
	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<>();
		map.put("jack",88);
		map.put("marry",22);
		map.put("hello",33);
		for (String key:map.keySet()){
			System.out.println(key+""+map.get(key));
		}
		for (Map.Entry<String,Integer> entry:map.entrySet()){
			System.out.println(entry.getKey()+""+entry.getValue());
		}
	}
}
