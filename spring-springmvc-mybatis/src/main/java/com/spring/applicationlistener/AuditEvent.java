package com.spring.applicationlistener;

import org.springframework.context.ApplicationEvent;

/**
 * ����¼�Դ
 * 
 * @author Tim
 *
 */
public class AuditEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private Boolean status; // ��ǰ�걨״̬
	private String work;// �걨��Ʒ
	private String advice;// ��ǰ�걨���

	public AuditEvent(Object source) {
		super(source);
		status = true;// ��ʼ��̨
		advice = "��δ���";
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}
}
