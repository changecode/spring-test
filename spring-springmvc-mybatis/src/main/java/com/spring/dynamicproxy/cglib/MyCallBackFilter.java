package com.spring.dynamicproxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.CallbackFilter;

/**
 * 拦截过滤器
 * 
 * @author Tim
 *
 */
public class MyCallBackFilter implements CallbackFilter {

	@Override
	public int accept(Method method) {
		if ("method3".equals(method.getName())) {// 如果被拦截的方法名满足特定条件
			// 这里的序号对应于enhancer.setCallbacks(new Callback[]{new
			// MyTimeInterceptor(),new MyRecordInterceptor()})中的Callback数组的拦截器索引
			return 1;
		} else {
			return 0;
		}
	}
}
