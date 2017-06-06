package com.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * ����֪ͨ
 * 
 * @author Tim
 *
 */
public class AroundAdvice implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("������ǿ���ÿ�ʼ");
		System.out.println(invocation.getArguments()[0] + "����" + invocation.getStaticPart() + "����"
				+ invocation.getThis().getClass() + "����" + invocation.getMethod().getName());
		invocation.proceed();// �������Ŀ����󷽷�
		System.out.println("������ǿ���ý���");
		return "I'm around return value";
	}

}
