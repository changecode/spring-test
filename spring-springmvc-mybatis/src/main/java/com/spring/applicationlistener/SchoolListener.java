package com.spring.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * �¼�������
 * 
 * @author Tim
 *
 */
public class SchoolListener implements SmartApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("��ȡ��ǰ���걨״̬Ϊ��" + ((AuditEvent) event).getStatus() + "����" + ((AuditEvent) event).getAdvice());
		((AuditEvent) event).setStatus(true);
		((AuditEvent) event).setAdvice("ѧУ���������д��⣬�ǳ�����");
	}

	@Override
	public int getOrder() {
		return 1;
	}

	/**
	 * �������ǵļ�������������֮һ���ܹ������¼����Ͷ�̬����
	 */
	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return eventType == AuditEvent.class;
	}

	/**
	 * �������ǵļ�������������֮�����ܹ������¼����������Ͷ�̬����
	 */
	@Override
	public boolean supportsSourceType(Class<?> sourceType) {
		return sourceType == Publisher.class;
	}

}
