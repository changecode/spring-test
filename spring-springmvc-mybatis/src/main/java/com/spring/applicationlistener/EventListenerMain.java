package com.spring.applicationlistener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 对事件顺序执行流水作业测试
 * @author Tim
 *
 */
public class EventListenerMain {

	@SuppressWarnings("resource")
	public static void main(String args[]) throws InterruptedException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-eventlistener.xml");
        Publisher publish = (Publisher) ac.getBean("publisher");
        publish.reportWorks();//小白要开始申报项目啦
    }
}
