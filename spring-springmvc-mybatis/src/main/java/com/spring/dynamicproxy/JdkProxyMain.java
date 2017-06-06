package com.spring.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 测试采用jdk动态代理统计方法执行时间差
 * 
 * @author Tim
 *
 */
public class JdkProxyMain {

	public static void main(String[] args) throws InterruptedException {
		/** 被代理对象 */
		OldClass oldClass = new OldClass();
		/** 注入被代理对象 */
		InvocationHandler invocatioHandler = new MyInvokationHandler<OldClass>(oldClass);

		/**
		 * 第一个参数 - 定义代理类的类加载器 
		 * 第二个参数 - 代理类要实现的接口列表 
		 * 第三个参数- 指派方法调用的调用处理程序
		 * InvocationHandler
		 */
		MyProxy myproxy = (MyProxy) Proxy.newProxyInstance(MyProxy.class.getClassLoader(),
				new Class[] { MyProxy.class }, invocatioHandler);
		myproxy.method1();
		myproxy.method2();
		myproxy.method3();
	}
}
