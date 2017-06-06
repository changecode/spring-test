package com.spring.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * CGLib的区别在于通过在程序运行时动态生成一个被代理类的子类的方式来完成代理。它有几个核心类: 1. Enhancer
 * 它用于动态生成被代理的类的子类。使用此类生成子类的前奏是指定被代理类和指定CallBack接口 2.
 * CallBack：它是一个很关键的接口，我们常常通过CallBack接口来配置我们的拦截方法， 3.
 * MethodInterceptor：是CallBack的实现类，他会拦截我们被代理类的所有方法，来实现自己的增强细节。比如做点日志记录，方法处理等，
 * 处理完后，还能通过MethodProxy重新调用拦截掉的方法。 4.
 * MethodProxy：主要用于重新调用MethodInterceptor拦截掉的方法，是jdk反射包中Method的代理类。 5.
 * CallbackFilter：一个Enhancer生成类可以指定多个Callback,这样我们可以设定条件过滤，
 * 让被代理类中不同的方法被调用时使用不同的CallBack来进行处理。
 * 
 * @author Tim
 *
 */
public class CglibProxyFactory {

	// 动态的类生成器
	private Enhancer enhancer = new Enhancer();

	public Object createSubObject(Class<?> clazz) {
		enhancer.setSuperclass(clazz);// 设置需要创建的类，这个类的父类是clazz类
		// 当通过enhancer创建的类中的方法被调用时，该方法会被CallBack指定的对象拦截。
		enhancer.setCallbacks(new Callback[] { new MyTimeInterceptor(), new MyRecordInterceptor() });
		enhancer.setCallbackFilter(new MyCallBackFilter());// 设置我们自定义的过滤器
		return enhancer.create();// 通过字节码技术动态创建子类实例
	}
}
