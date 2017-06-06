package com.spring.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * CGLib����������ͨ���ڳ�������ʱ��̬����һ���������������ķ�ʽ����ɴ������м���������: 1. Enhancer
 * �����ڶ�̬���ɱ������������ࡣʹ�ô������������ǰ����ָ�����������ָ��CallBack�ӿ� 2.
 * CallBack������һ���ܹؼ��Ľӿڣ����ǳ���ͨ��CallBack�ӿ����������ǵ����ط����� 3.
 * MethodInterceptor����CallBack��ʵ���࣬�����������Ǳ�����������з�������ʵ���Լ�����ǿϸ�ڡ�����������־��¼����������ȣ�
 * ������󣬻���ͨ��MethodProxy���µ������ص��ķ����� 4.
 * MethodProxy����Ҫ�������µ���MethodInterceptor���ص��ķ�������jdk�������Method�Ĵ����ࡣ 5.
 * CallbackFilter��һ��Enhancer���������ָ�����Callback,�������ǿ����趨�������ˣ�
 * �ñ��������в�ͬ�ķ���������ʱʹ�ò�ͬ��CallBack�����д���
 * 
 * @author Tim
 *
 */
public class CglibProxyFactory {

	// ��̬����������
	private Enhancer enhancer = new Enhancer();

	public Object createSubObject(Class<?> clazz) {
		enhancer.setSuperclass(clazz);// ������Ҫ�������࣬�����ĸ�����clazz��
		// ��ͨ��enhancer���������еķ���������ʱ���÷����ᱻCallBackָ���Ķ������ء�
		enhancer.setCallbacks(new Callback[] { new MyTimeInterceptor(), new MyRecordInterceptor() });
		enhancer.setCallbackFilter(new MyCallBackFilter());// ���������Զ���Ĺ�����
		return enhancer.create();// ͨ���ֽ��뼼����̬��������ʵ��
	}
}
