package com.spring.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ��������ʹ���˷��ͣ����������кܶ���඼��Ҫ�������ܼ�أ� �Ϳ���ͨ���ڴ����������ʱ�ڷ��ͱ�ʶ���ĳɶ�Ӧ��Ҫ��ص��༴��
 * 
 * @author Tim
 *
 * @param <T>
 */
public class MyInvokationHandler<T> implements InvocationHandler {

	// ��Ҫ������Ķ���
	private T target;

	public MyInvokationHandler(T _target) {
		this.target = _target;
	}

	/**
	 * @param�� proxy : �����ϵ��÷����Ĵ���ʵ�� method : ��Ӧ����Ŀ�������õķ����� 
	 * args : �����������ʵ���Ϸ������õĲ���ֵ�Ķ������飬����ӿڷ�����ʹ�ò�������Ϊ null �������͵Ĳ�������װ���ʵ�������װ���ࣨ��
	 * java.lang.Integer �� java.lang.Boolean����ʵ���С�
	 * 
	 * @return �Ӵ���ʵ���ķ������÷��ص�ֵ������ӿڷ������������������ǻ������ͣ�
	 *         ��˷������ص�ֵһ������Ӧ������װ�������ʵ����������һ���ǿɷ��䵽�����������͵����͡� ����˷������ص�ֵΪ null
	 *         ���ҽӿڷ����ķ��������ǻ������ͣ������ʵ���ϵķ������ý��׳� NullPointerException
	 *         ��������˷������ص�ֵ�������ӿڷ����������������Ͳ����ݣ������ʵ���ϵķ������ý��׳� ClassCastException��
	 * @throws Throwable
	 *             - �Ӵ���ʵ���ϵķ��������׳����쳣�� ���쳣�����ͱ�����Է��䵽�ڽӿڷ����� throws �Ӿ�����������һ�쳣����
	 *             ��δ�������쳣���� java.lang.RuntimeException �� java.lang.Error��
	 *             ����˷����׳����������쳣�����쳣���ɷ��䵽�ڽӿڷ����� throws �Ӿ�����������һ�쳣����.
	 *             ����ʵ���ķ������ý��׳������˷������׳����쳣�� UndeclaredThrowableException��
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// ��¼��ʼʱ��
		Long beginTime = System.currentTimeMillis();
		// ����Ŀ�����ķ�����ͬʱ��ȡ�÷����ķ���ֵ����Ϊ���Ǳ�������(invoke)�ķ���ֵ
		Object returnValue = method.invoke(target, args);
		// targetΪ���Ƿ������ڵ�Ŀ���࣬argsΪ��������
		System.out.println("����" + method.getName() + "���ý�������ʱ" + (System.currentTimeMillis() - beginTime));
		return returnValue;
	}

}
