package com.itwn.homework.task0703.task10;

public class Juicer {
	private String name;

	public Juicer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Juicer(String name) {
		this.name = name;
	}

	public void squeeze(Object...objs){
		System.out.println(this.name+"榨汁：");
		for (Object o:objs){
			System.out.print(o+"+");
		}
		autoClean();
	}
	private void autoClean(){
		System.out.println("清洗清洗");
	}

	public static void main(String[] args) {
		Juicer juicer=new Juicer("红色苏泊尔");
		juicer.squeeze(new Apple(),new Watermelon());
		juicer.squeeze(new RedBean(),new Soybean(),new RedBean());
	}

}
