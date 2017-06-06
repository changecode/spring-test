package com.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.Itarget;

public class SpringAopTest {

	private ApplicationContext ac;

	@Before
	public void setup() {
		ac = new ClassPathXmlApplicationContext("classpath:spring-aop.xml");
	}

	@Test
	public void test() {
		Itarget iTarget = (Itarget) ac.getBean("proxyFactoryBean");
		iTarget.speak(21);
	}

	@Test
	public void testAspectAnnotation() {
		com.spring.aspectjAnnotation.Target target = (com.spring.aspectjAnnotation.Target) ac.getBean("target");
		target.speak(21);
	}
}
