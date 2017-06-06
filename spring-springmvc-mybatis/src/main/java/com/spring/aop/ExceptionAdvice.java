package com.spring.aop;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.springframework.aop.ThrowsAdvice;

/**
 * 异常增强
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
     * 三个入参Method method, Object[] args, Object target 要么一起提供，要么都不提供，
     * 而最后一个入参必须为Throwable或其子类。当目标对象抛出异常时，增强会调用相似度最高的匹配异常类的方法
     */
    public void AfterThrowing(Method method, Object[] args, Object target,SQLException e){
        System.out.println(e.getMessage());
    }
}
