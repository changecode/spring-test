package com.spring.dynamicproxy.cglib;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * ��־��¼������
 * 
 * @author Tim
 *
 */
public class MyRecordInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {// �������и��෽���ĵ���
		System.out.println(args[0] + "��" + new SimpleDateFormat("yyyy-MM-dd HH-mm").format(new Date()) + "�����˷���"
				+ method.getName());
		Object returnValue = proxy.invokeSuper(target, args);// targetΪ���Ƿ������ڵ�Ŀ���࣬argsΪ��������
		return returnValue;
	}
}
