package com.itwn.test.examtest;
public class Test04 {
	private int ticket=100;
	public void sale(){
		while (true) {
			synchronized (this) { //int.class  Test04.class
				if (ticket<=0){
					System.out.println("售罄");
					break;
				} //这个的目的是打破循环
				//如果是单线程写在前写在后都没有关系，但是对于多线程判断要写在前面
				// 如果写在后面：因为多个线程都会进入循环，
				// 可能线程一进行完操作 跳出循环 但进程二 还在
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "正在卖" + ticket + "票");
				ticket--;

			}
		}
	}
	public static void main(String[] args) {
		Test04 t1=new Test04();
		new Thread(t1::sale,"一号窗口").start();
		new Thread(t1::sale,"二号窗口").start();
	}
}

