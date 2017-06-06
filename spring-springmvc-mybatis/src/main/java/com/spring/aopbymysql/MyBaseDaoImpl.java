package com.spring.aopbymysql;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyBaseDaoImpl implements com.spring.aopbymysql.MyBaseDao{

	private ThreadLocal<Integer> sourceType = new ThreadLocal<Integer>();
	
	@Autowired
	@Qualifier("sessionFactory1")
	private SessionFactory sessionFactory1;
	
	@Autowired
	@Qualifier("sessionFactory2")
	private SessionFactory sessionFactory2;
	
	@Override
	public SessionFactory getSessionFactory() {
		if(sourceType.get() == null){
			sourceType.set(1);
		}
		switch (sourceType.get()) {
		case 1:
			return sessionFactory1;
		case 2:
			return sessionFactory2;
		default:
			throw new IllegalArgumentException("not found datasource");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E add(Object object) {
		return (E) getSessionFactory().openSession().save(object);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <E> E queryUnique(Class<E> clazz, Integer entityId) {
		return (E) getSessionFactory().openSession().get(clazz, entityId);
	}

	@Override
	public void setSourceType(Integer sourceType) {
		this.sourceType.set(sourceType);
	}

}
