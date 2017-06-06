package com.spring.aop;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.springframework.aop.ThrowsAdvice;

/**
 * �쳣��ǿ
 * @author Tim
 *
 */
public class ExceptionAdvice implements ThrowsAdvice{

	public void AfterThrowing(SQLException e){
        System.out.println(e.getMessage());
    }
	
    public void AfterThrowing(RuntimeException e){
        System.out.println(e.getMessage());
    }
    
    /**
     * @param method
     * @param args
     * @param target
     * @param e
     * �������Method method, Object[] args, Object target Ҫôһ���ṩ��Ҫô�����ṩ��
     * �����һ����α���ΪThrowable�������ࡣ��Ŀ������׳��쳣ʱ����ǿ��������ƶ���ߵ�ƥ���쳣��ķ���
     */
    public void AfterThrowing(Method method, Object[] args, Object target,SQLException e){
        System.out.println(e.getMessage());
    }
}
