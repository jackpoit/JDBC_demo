package com.itwn.homework.task0703.task08;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Door[] doors=new Door[]{new Push(),new AntuThief(),new Elevator()};

		for (Door door:doors){
			door.open();
			door.close();
		}
		new AntuThief().preFire();
		new Elevator().preSmoke();
		new MultiDoor(){}.preFire();
		new MultiDoor(){}.preSmoke();
	}
}
