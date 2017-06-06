package com.spring.aopbymysql;

import org.hibernate.SessionFactory;

/**
 * @author Tim
 *
 */
public interface MyBaseDao {

	SessionFactory getSessionFactory();

	<E> E add(Object object);

	<E> E queryUnique(Class<E> clazz, Integer entityId);

	void setSourceType(Integer sourceType);
}
