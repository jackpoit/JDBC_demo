package com.itwn.homework.task0630;

import java.util.*;

public class ComparatorAssert {
	public static void main(String[] args) {
		//3. 键盘输入任意字符串，统计每个字符出现的次数？ 【两种方法】
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入");
		String input=scanner.next();

		//1.
		Map<Character,Integer> map=new TreeMap<>();
		for (int i=0;i<input.length();i++){
			char c=input.charAt(i);
			if (map.containsKey(c)){
				map.put(c,map.get(c)+1);
			}else {
				map.put(c,1);
			}
		}
		for (char key:map.keySet()){
			System.out.println(key+"出现的次数为："+map.get(key));
		}

		System.out.println();
		System.out.println();
		System.out.println();

		//2.
		List<MyChar> list=new ArrayList<>();
		for (int i=0;i<input.length();i++){
			char c=input.charAt(i);
			MyChar temp=isExists(c,list);
			if (temp==null){
				list.add(new MyChar(c,1));
			}else {
				temp.setCount(temp.getCount()+1);
			}
		}
		list.sort(new Comparator<MyChar>() {
			@Override
			public int compare(MyChar o1, MyChar o2) {
				return Character.compare(o1.getC(),o2.getC());
			}
		});
		list.sort(Comparator.comparingInt(MyChar::getC));
//		list.sort((MyChar o1,MyChar o2)->{
//			return Character.compare(o1.getC(),o2.getC());
//		});
		for (MyChar e:list){
			System.out.println(e.getC()+"出现的次数"+e.getCount());
		}


	}
	private static MyChar isExists(char c,List<MyChar> list){
		for (MyChar e:list){
			if (e.getC()==c)
				return e;
		}
		return null;
	}

	static class MyChar{
		private char c;
		private int count;

		public MyChar() {
		}

		public MyChar(char c, int count) {
			this.c = c;
			this.count = count;
		}

		public char getC() {
			return c;
		}

		public void setC(char c) {
			this.c = c;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
	}
}
