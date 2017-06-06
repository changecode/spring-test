package com.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 后置通知
 * @author Tim
 *
 */
public class AfterAdvice implements AfterReturningAdvice {

	/**
	 * @param returnValue
	 *            返回值 method:目标类的方法 args: 目标类的方法入参 obj:目标类实例
	 * 
	 */
	@SuppressWarnings("static-access")
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		if (target instanceof Target) {
			System.out.println(
					"后置日志记录： " + ((Target) target).getName() + "调用了" + method.getName() + "方法,返回值为：" + returnValue);
		}
	}

}
