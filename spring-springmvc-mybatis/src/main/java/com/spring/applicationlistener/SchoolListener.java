package com.spring.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * 事件监听器
 * 
 * @author Tim
 *
 */
public class SchoolListener implements SmartApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("获取当前的申报状态为：" + ((AuditEvent) event).getStatus() + "——" + ((AuditEvent) event).getAdvice());
		((AuditEvent) event).setStatus(true);
		((AuditEvent) event).setAdvice("学校审核意见：有创意，非常棒！");
	}

	@Override
	public int getOrder() {
		return 1;
	}

	/**
	 * 这是我们的监听器智能所在之一，能够根据事件类型动态监听
	 */
	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return eventType == AuditEvent.class;
	}

	/**
	 * 这是我们的监听器智能所在之二，能够根据事件发布者类型动态监听
	 */
	@Override
	public boolean supportsSourceType(Class<?> sourceType) {
		return sourceType == Publisher.class;
	}

}
