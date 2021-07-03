package com.itwn.homework.task0703.task08;

public interface MultiDoor extends Door, SmokeAlarm, FireAlarm {

	@Override
	default void preFire(){
		System.out.println("多功能门的防火");
	}
	@Override
	default void preSmoke(){
		System.out.println("多功能门的防烟");
	}
}
