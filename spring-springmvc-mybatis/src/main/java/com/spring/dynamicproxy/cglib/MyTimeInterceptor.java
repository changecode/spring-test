package com.spring.dynamicproxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * ��ʱͳ��������
 * 
 * @author Tim
 *
 */
public class MyTimeInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Long beginTime = System.currentTimeMillis();// ��¼��ʼʱ��
		// ����Ŀ�����ķ�����ͬʱ��ȡ�÷����ķ���ֵ����Ϊ���Ǳ�������(invoke)�ķ���ֵ
		Object returnValue = proxy.invokeSuper(target, args);// targetΪ���Ƿ������ڵ�Ŀ���࣬argsΪ��������
		System.out.println("����" + method.getName() + "���ý�������ʱ" + (System.currentTimeMillis() - beginTime));
		return returnValue;
	}

}
