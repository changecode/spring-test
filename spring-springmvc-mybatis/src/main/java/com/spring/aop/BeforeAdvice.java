package com.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * ǰ��֪ͨ
 * @author Tim
 *
 */
public class BeforeAdvice implements MethodBeforeAdvice {

	/**
	 * @param method:Ŀ����ķ���
	 *  args: Ŀ����ķ������ obj:Ŀ����ʵ��
	 * 
	 */
	@SuppressWarnings("static-access")
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		if (target instanceof Target) {
			System.out.println(
					"ǰ����־��¼�� " + ((Target) target).getName() + "������" + method.getName() + "����,�������Ϊ��" + args[0]);
		}
	}

}
