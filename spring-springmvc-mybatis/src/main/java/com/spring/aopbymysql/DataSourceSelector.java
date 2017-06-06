package com.spring.aopbymysql;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DataSourceSelector {

	@Before("execution( * com.spring.aopbymysql.MyBaseDaoImpl.add*(..))")//Ð´²Ù×÷
    public void before1(JoinPoint joinPoint){
        ((MyBaseDao)joinPoint.getTarget()).setSourceType(1);//ÇÐ»»µ½Ö÷¿â
    }

    @Before("execution( * com.spring.aopbymysql.MyBaseDaoImpl.query*(..))")//¶Á²Ù×÷
    public void before2(JoinPoint joinPoint){
        ((MyBaseDao)joinPoint.getTarget()).setSourceType(2);//ÇÐ»»µ½´Ó¿â
    }
}
