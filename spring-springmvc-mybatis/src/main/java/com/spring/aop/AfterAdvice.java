package com.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * ����֪ͨ
 * @author Tim
 *
 */
public class AfterAdvice implements AfterReturningAdvice {

	/**
	 * @param returnValue
	 *            ����ֵ method:Ŀ����ķ��� args: Ŀ����ķ������ obj:Ŀ����ʵ��
	 * 
	 */
	@SuppressWarnings("static-access")
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		if (target instanceof Target) {
			System.out.println(
					"������־��¼�� " + ((Target) target).getName() + "������" + method.getName() + "����,����ֵΪ��" + returnValue);
		}
	}

}
