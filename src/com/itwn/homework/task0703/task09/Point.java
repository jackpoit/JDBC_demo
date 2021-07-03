package com.itwn.homework.task0703.task09;

public class Point {
	private int x;
	private int y;


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
	}

	@Override
	public String toString() {
		return "点，点的坐标为("+x+","+y+")";
	}
}
