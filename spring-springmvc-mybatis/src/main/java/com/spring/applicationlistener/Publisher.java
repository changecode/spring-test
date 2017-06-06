package com.spring.applicationlistener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 事件发布者 event publisher
 * 
 * @author Tim 模拟发布作品经过层层审批的业务，同步执行的流水线 学校-升级-国级
 */
public class Publisher implements ApplicationContextAware {

	// 底层事件发布者
	private ApplicationContext applicationContext;

	// 申报作品
	public void reportWorks() {
		AuditEvent auditEvent = new AuditEvent(this);
		applicationContext.publishEvent(auditEvent);
		System.out.println("最终审核结果：" + auditEvent.getStatus() + "——" + auditEvent.getAdvice());
	}

	@Override
	public void setApplicationContext(ApplicationContext _applicationContext) throws BeansException {
		this.applicationContext = _applicationContext;
	}

}
