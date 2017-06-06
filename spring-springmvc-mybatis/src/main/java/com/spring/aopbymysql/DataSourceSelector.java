package com.spring.aopbymysql;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DataSourceSelector {

	@Before("execution( * com.spring.aopbymysql.MyBaseDaoImpl.add*(..))")//д����
    public void before1(JoinPoint joinPoint){
        ((MyBaseDao)joinPoint.getTarget()).setSourceType(1);//�л�������
    }

    @Before("execution( * com.spring.aopbymysql.MyBaseDaoImpl.query*(..))")//������
    public void before2(JoinPoint joinPoint){
        ((MyBaseDao)joinPoint.getTarget()).setSourceType(2);//�л����ӿ�
    }
}
