package com.spring.dynamicproxy.cglib;

/**
 * 被代理对象
 * 
 * @author Tim
 *
 */
public class OldClass {

	public void method1() throws InterruptedException {
		System.out.println("正在处理业务逻辑1");
		Thread.sleep(100);// 模拟处理业务逻辑4过程
		System.out.println("业务逻辑1处理完成");
	}

	public void method2() throws InterruptedException {
		System.out.println("正在处理业务逻辑2");
		Thread.sleep(200);// 模拟处理业务逻辑2过程
		System.out.println("业务逻辑2处理完成");
	}

	public void method3(String msg) throws InterruptedException {
		System.out.println("正在处理业务逻辑" + msg);
		Thread.sleep(300);// 模拟处理业务逻辑3过程
		System.out.println("业务逻辑3处理完成");
	}

}
