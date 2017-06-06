package com.spring.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * ���Բ���jdk��̬����ͳ�Ʒ���ִ��ʱ���
 * 
 * @author Tim
 *
 */
public class JdkProxyMain {

	public static void main(String[] args) throws InterruptedException {
		/** ��������� */
		OldClass oldClass = new OldClass();
		/** ע�뱻������� */
		InvocationHandler invocatioHandler = new MyInvokationHandler<OldClass>(oldClass);

		/**
		 * ��һ������ - ����������������� 
		 * �ڶ������� - ������Ҫʵ�ֵĽӿ��б� 
		 * ����������- ָ�ɷ������õĵ��ô������
		 * InvocationHandler
		 */
		MyProxy myproxy = (MyProxy) Proxy.newProxyInstance(MyProxy.class.getClassLoader(),
				new Class[] { MyProxy.class }, invocatioHandler);
		myproxy.method1();
		myproxy.method2();
		myproxy.method3();
	}
}
