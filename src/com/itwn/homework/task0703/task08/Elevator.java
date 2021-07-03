package com.itwn.homework.task0703.task08;

public class Elevator implements Door, SmokeAlarm {

	@Override
	public void open() {
		System.out.println("开电梯门");
	}

	@Override
	public void close() {
		System.out.println("关电梯门");
	}

	@Override
	public void preSmoke() {
		System.out.println("防盗门的防烟功能");
	}
}
