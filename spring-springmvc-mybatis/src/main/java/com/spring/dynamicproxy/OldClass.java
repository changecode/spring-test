package com.spring.dynamicproxy;

/**
 * ���������
 * 
 * @author Tim
 *
 */
public class OldClass implements MyProxy {

	@Override
	public void method1() throws InterruptedException {
		System.out.println("���ڴ���ҵ���߼�1");
		Thread.sleep(100);// ģ�⴦��ҵ���߼�4����
		System.out.println("ҵ���߼�1�������");
	}

	@Override
	public void method2() throws InterruptedException {
		System.out.println("���ڴ���ҵ���߼�2");
		Thread.sleep(200);// ģ�⴦��ҵ���߼�2����
		System.out.println("ҵ���߼�2�������");
	}

	@Override
	public void method3() throws InterruptedException {
		System.out.println("���ڴ���ҵ���߼�3");
		Thread.sleep(300);// ģ�⴦��ҵ���߼�3����
		System.out.println("ҵ���߼�3�������");
	}

}
