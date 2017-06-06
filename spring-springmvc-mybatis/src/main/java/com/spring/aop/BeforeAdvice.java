package com.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 前置通知
 * @author Tim
 *
 */
public class BeforeAdvice implements MethodBeforeAdvice {

	/**
	 * @param method:目标类的方法
	 *  args: 目标类的方法入参 obj:目标类实例
	 * 
	 */
	@SuppressWarnings("static-access")
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		if (target instanceof Target) {
			System.out.println(
					"前置日志记录： " + ((Target) target).getName() + "调用了" + method.getName() + "方法,传入参数为：" + args[0]);
		}
	}

}
