package com.spring.dynamicproxy.cglib;

/**
 * ���������
 * 
 * @author Tim
 *
 */
public class OldClass {

	public void method1() throws InterruptedException {
		System.out.println("���ڴ���ҵ���߼�1");
		Thread.sleep(100);// ģ�⴦��ҵ���߼�4����
		System.out.println("ҵ���߼�1�������");
	}

	public void method2() throws InterruptedException {
		System.out.println("���ڴ���ҵ���߼�2");
		Thread.sleep(200);// ģ�⴦��ҵ���߼�2����
		System.out.println("ҵ���߼�2�������");
	}

	public void method3(String msg) throws InterruptedException {
		System.out.println("���ڴ���ҵ���߼�" + msg);
		Thread.sleep(300);// ģ�⴦��ҵ���߼�3����
		System.out.println("ҵ���߼�3�������");
	}

}
