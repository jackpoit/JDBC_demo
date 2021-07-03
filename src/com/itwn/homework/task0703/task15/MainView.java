package com.itwn.homework.task0703.task15;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainView {
	private static Scanner scanner=new Scanner(System.in);
	private static Library lib=new Library();
	public static void main(String[] args) {
		mainView();
	}
	public static void mainView(){
		while (true){
			System.out.println("***************** 欢迎进入图书馆关系系统 **********************");
			System.out.println("1.查看所有书籍信息");
			System.out.println("2.添加图书");
			System.out.println("3.根据书籍名称删除书籍");
			System.out.println("4.根据书籍名称模糊搜索书籍");
			System.out.println("5.退出系统");
			System.out.println("******************************************************************");
			System.out.println("请输入选项：");
			String input=scanner.next();
			if ("1".equals(input)){
				lib.queryAll();
			}else if("2".equals(input)){
				addBook();
			}else if("3".equals(input)){
				delBook();
			}else if("4".equals(input)){
				queryView();
			}else if("5".equals(input)){
				System.exit(0);
			}else{
				System.out.println("输入错误,请重新输入");
			}
		}
	}
	public static void addBook(){
		System.out.println("------------------  开始添加图书 -------------------");
		while (true){
			System.out.println("请输入图书编号：");
			Integer id=Integer.parseInt(scanner.next());
			System.out.println("请输入图书名称：");
			String name=scanner.next();
			System.out.println("请输入图书作者：");
			String author=scanner.next();
			System.out.println("请输入图书价格（元）:");
			BigDecimal price=new BigDecimal(scanner.next());
			Book book=new Book(id,name,author,price);
			if (lib.addBook(book)){
				System.out.println("添加成功");
			}else {
				System.out.println(" 该图书已存在，不能添加");
			}
			System.out.println("是否需要继续添加(y/n)：");
			String input=scanner.next();
			if (!"y".equals(input)){
				break;
			}
		}

	}
	public static void queryView(){
		while (true){
			System.out.println("请输入图书名称：");
			String name=scanner.next();
			lib.queryBook(name);
			System.out.println("----------------------------------------");
			System.out.println("是否需要继续查询(y/n)：");
			String input=scanner.next();
			if (!"y".equals(input)){
				break;
			}
		}

	}

	public static void delBook(){
		System.out.println("请输入图书编号：");
		int id=scanner.nextInt();
		if (lib.delBook(id)){
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
}
