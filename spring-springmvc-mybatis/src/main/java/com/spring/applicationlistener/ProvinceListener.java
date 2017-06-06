package com.spring.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * 二级审核
 * 
 * @author Tim
 *
 */
public class ProvinceListener implements SmartApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		/** 如果上层审核通过 */
		if (((AuditEvent) event).getStatus()) {
			System.out.println(
					"获取当前的申报状态为：" + ((AuditEvent) event).getStatus() + "——" + ((AuditEvent) event).getAdvice());
			((AuditEvent) event).setStatus(true);
			((AuditEvent) event).setAdvice("省级审核意见：还行，通过吧！");
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
