package com.spring.aspectjAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**ע��Ϊ���棬��IOC����ʶ������AOP*/
@Aspect
public class BeforeAdvice {

	/**
	 * ����ǰ����ǿ����λ�е�,���嵽test.aop���µ�Target�����
	 * public����StringΪ����ֵ���ͣ����ΪInteger��speak����
	 * @param joinPoint
	 * 
	 * @Before(value,argNames) ǰ����ǿ
 	 * value�������е� 
 	 * argsName��ָ��ע������ע����ǿ�����Ĳ���������������ö��ø���
 	 * 
 	 * @AfterReturning(value/pointcut,returning,argNames) ������ǿ
 	 * value/pointcut:�����е㣬��ͬʱ���壬value�ᱻpointcut���� 
 	 * returning:��Ŀ�����ķ����󶨵���ǿ�ķ�����
 	 * 
 	 * AfterThrowing(value/pointcut,throwing,argNames) �쳣��ǿ
 	 * throwing:���׳����쳣�󶨵���ǿ������
 	 * 
 	 * After(value,argNames) ���գ�final)��ǿ
 	 * �������׳��쳣���������˳�������ִ�д���ǿ
	 */
	/*@Before("execution(public String com.spring.aspectjAnnotation.Target.speak(Integer))")
	public void before(JoinPoint joinPoint) {
		System.out.println("ǰ����־��¼�� "
                + ((Target) joinPoint.getTarget()).getName() + "������"
                + joinPoint.getSignature().getName() + "����,�������Ϊ��"
                + joinPoint.getArgs()[0]);
	}*/
	
	/**
	 * �����е㺯��
	 * execution(* com.yc.service.*.*(..))������service����������ʱ���ã���λ�����ⷵ�����ͣ���һ��"*") 
	 * ��com.yc.service���µ������ࣨ�ڶ���"*")�µ����з�����������"*"),��������������Ϊ�������͡������������� "(..)"��
	 * 
	 * execution(<���η�> <��������> <��·��> <������>(<�����б�>) <�쳣ģʽ>
	 * 1. ͨ������ǩ��������ֵ�����е㣺
	 * execution(public * *Service(..))`����λ���������·���ֵ���⡢����������͡��������⣬public���͵ķ���
	 * execution(public String *Service(..))`����λ���������·���ֵΪString������������͡��������⣬public���͵ķ���
	 * 2. ͨ����������е㣺
	 * execution(* com.yc.controller.BaseController+.*(..))`:ƥ�����ⷵ�����ͣ���Ӧ����BaseController�༰����������ⷽ����
	 * execution(* com.*.(..))`:ƥ�����ⷵ�����ͣ�com��������������з���
	 * execution(* com..*.(..))`:ƥ�����ⷵ�����ͣ�com�����Ӱ�������������з���
	 * ע��.��ʾ�ð��������࣬..�������Ӱ���
	 * 3. ͨ��������ζ����е�
	 * ���\*����ʾ�������͵�һ����������..����ʾ�����������������Ĳ���
	 * execution(* speak(Integer,*))`:ƥ�����ⷵ�����ͣ���������ֻ��������Σ���һ�����ΪInteger���ڶ����������ķ���
	 * execution(* speak(..,Integer,..))`:ƥ�����ⷵ�����ͣ���������������һ��Integer��Σ���λ������ķ�����
	 */
	
	/**
	 *  ͬһ�����У���ͬ��ǿ��֯��˳��Ϊ��������ǿǰ�벿��->ǰ����ǿ->ԭĿ�꺯������->������ǿ��벿��->������ǿ->������ǿ
	 *  û��ʵ��order�ӿڵġ����ȼ������ǵ���ʵ����order�ӿ�
	 *  ���ͬһ���͵���ǿ���綼��ǰ����ǿ����ͬһ���ӵ��֯��˳���ǣ�
	 *  ���������ȼ���˭���ȼ��ߣ����ȼ���ͬ��˭����IOC����ע�ᣬ������order�ӿڻ�ע�͵���ǿ���ȼ����Ǹ���û���õ�
	 */
	
	/**
	 * ��������ǿ�����а����org.aspectj.lang.JoinPoint
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("execution(public String com.spring.aspectjAnnotation.Target.speak(Integer))")
    public void before(JoinPoint joinPoint) throws Throwable {
        System.out.println("ǰ����־��¼�� "
                + ((Target) joinPoint.getTarget()).getName() + "������"
                + joinPoint.getSignature().getName() + "����,�������Ϊ��"
                + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getTarget());//��ȡĿ�����
        System.out.println(joinPoint.getThis());//��ȡĿ�����
        System.out.println(joinPoint.getArgs());//��ȡĿ����󷽷����
        System.out.println(joinPoint.getClass());
        System.out.println(joinPoint.getSignature());//��ȡ�����ķ���ǩ��
        System.out.println(joinPoint.getSourceLocation());
        System.out.println(joinPoint.getStaticPart());//��ȡ�е㶨λ��Ϣ
    }
}
