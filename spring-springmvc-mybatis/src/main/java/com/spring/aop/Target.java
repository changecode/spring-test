package com.spring.aop;

/**
 * ���������
 * @author Tim
 *
 */
public class Target implements Itarget {

	private static final String name = "zenghao";

	@Override
	public String speak(Integer age) {
		System.out.println("hello I'm " + age + " years old");
		return "I'm return value";
	}

	public static String getName() {
		return name;
	}

}
