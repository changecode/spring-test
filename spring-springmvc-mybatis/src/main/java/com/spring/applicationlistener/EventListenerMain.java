package com.spring.applicationlistener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ���¼�˳��ִ����ˮ��ҵ����
 * @author Tim
 *
 */
public class EventListenerMain {

	@SuppressWarnings("resource")
	public static void main(String args[]) throws InterruptedException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-eventlistener.xml");
        Publisher publish = (Publisher) ac.getBean("publisher");
        publish.reportWorks();//С��Ҫ��ʼ�걨��Ŀ��
    }
}
