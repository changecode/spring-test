package com.spring.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * �������
 * 
 * @author Tim
 *
 */
public class ProvinceListener implements SmartApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		/** ����ϲ����ͨ�� */
		if (((AuditEvent) event).getStatus()) {
			System.out.println(
					"��ȡ��ǰ���걨״̬Ϊ��" + ((AuditEvent) event).getStatus() + "����" + ((AuditEvent) event).getAdvice());
			((AuditEvent) event).setStatus(true);
			((AuditEvent) event).setAdvice("ʡ�������������У�ͨ���ɣ�");
		}
	}

	@Override
	public int getOrder() {
		return 2;
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
