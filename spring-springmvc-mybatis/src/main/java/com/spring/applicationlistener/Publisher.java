package com.spring.applicationlistener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * �¼������� event publisher
 * 
 * @author Tim ģ�ⷢ����Ʒ�������������ҵ��ͬ��ִ�е���ˮ�� ѧУ-����-����
 */
public class Publisher implements ApplicationContextAware {

	// �ײ��¼�������
	private ApplicationContext applicationContext;

	// �걨��Ʒ
	public void reportWorks() {
		AuditEvent auditEvent = new AuditEvent(this);
		applicationContext.publishEvent(auditEvent);
		System.out.println("������˽����" + auditEvent.getStatus() + "����" + auditEvent.getAdvice());
	}

	@Override
	public void setApplicationContext(ApplicationContext _applicationContext) throws BeansException {
		this.applicationContext = _applicationContext;
	}

}
