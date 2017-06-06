package com.spring.dynamicproxy;

/**
 * 代理接口
 * 只能通过让被代理类实现代理接口的方式来生成代理
 * @author Tim
 *
 */
public interface MyProxy {

	void method1() throws InterruptedException;

	void method2() throws InterruptedException;

	void method3() throws InterruptedException;
}
