package com.itwn.homework.task0703.task09;

public class Circle {
	private Point center;
	private Integer r;

	public Circle() {
	}

	public Circle(Point center, Integer r) {
		this.center = center;
		this.r = r;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public Integer getR() {
		return r;
	}

	public void setR(Integer r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return "圆，圆心的坐标为("+center.getX()+","+center.getY()+"),半径为"+r+"cm";
	}
}
