package com.spring.dynamicproxy.cglib;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		CglibProxyFactory cgLibProxy = new CglibProxyFactory();// �������ǵĴ�����
		// ͨ��enhancer�������ǵ�����
		// ��ΪoldClass����������ĸ��࣬������������ת�ͳɹ�
		OldClass oldClass = (OldClass) cgLibProxy.createSubObject(OldClass.class);
		oldClass.method1();// ���÷���
		oldClass.method2();// ���÷���
		oldClass.method3("zenghao");// ���÷���
	}
}
