package com.itwn.homework.task0703.task09;

public class IDrawImpl implements IDraw {
	private  String name;

	public IDrawImpl() {
	}

	public IDrawImpl(String name) {
		this.name = name;
	}

	@Override
	public void draw(Object o) {
		System.out.println(name+"开始画画，画的是"+o);
	}

	public static void main(String[] args) {
		IDrawImpl painter=new IDrawImpl("达芬奇");
		painter.draw(new Point(3,4));
		painter.draw(new Circle(new Point(3,4),10));
	}
}
