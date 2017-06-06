package com.spring.aspectjAnnotation;

/**
 * @author Tim
 *
 */
public class Target {

	private static final String name = "zenghao";

	public String speak(Integer age) {
		System.out.println("hello I'm " + age + " years old");
		return "I'm return value";
	}

	public static String getName() {
		return name;
	}
}
