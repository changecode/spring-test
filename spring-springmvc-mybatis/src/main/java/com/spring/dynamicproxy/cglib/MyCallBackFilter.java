package com.spring.dynamicproxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.CallbackFilter;

/**
 * ���ع�����
 * 
 * @author Tim
 *
 */
public class MyCallBackFilter implements CallbackFilter {

	@Override
	public int accept(Method method) {
		if ("method3".equals(method.getName())) {// ��������صķ����������ض�����
			// �������Ŷ�Ӧ��enhancer.setCallbacks(new Callback[]{new
			// MyTimeInterceptor(),new MyRecordInterceptor()})�е�Callback���������������
			return 1;
		} else {
			return 0;
		}
	}
}
