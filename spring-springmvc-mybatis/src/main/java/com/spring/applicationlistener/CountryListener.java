package com.spring.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * �������
 * 
 * @author Tim
 *
 */
public class CountryListener implements SmartApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (((AuditEvent) event).getStatus()) {
			System.out.println(
					"��ȡ��ǰ���걨״̬Ϊ��" + ((AuditEvent) event).getStatus() + "����" + ((AuditEvent) event).getAdvice());
			((AuditEvent) event).setStatus(true);
			((AuditEvent) event).setAdvice("������������һ��㣬��ǿͨ���ɣ�");
		}
	}

	@Override
	public int getOrder() {
		return 3;
	}

	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return eventType == AuditEvent.class;
	}

	@Override
	public boolean supportsSourceType(Class<?> sourceType) {
		return sourceType == Publisher.class;
	}

}
