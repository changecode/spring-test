package com.spring.aspectjAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**注解为切面，让IOC容器识别并配置AOP*/
@Aspect
public class BeforeAdvice {

	/**
	 * 定义前置增强并定位切点,定义到test.aop包下的Target对象的
	 * public域以String为返回值类型，入参为Integer的speak方法
	 * @param joinPoint
	 * 
	 * @Before(value,argNames) 前置增强
 	 * value：定义切点 
 	 * argsName：指定注解所标注的增强方法的参数名，多个参数用都好隔开
 	 * 
 	 * @AfterReturning(value/pointcut,returning,argNames) 后置增强
 	 * value/pointcut:定义切点，若同时定义，value会被pointcut覆盖 
 	 * returning:将目标对象的方法绑定到增强的方法中
 	 * 
 	 * AfterThrowing(value/pointcut,throwing,argNames) 异常增强
 	 * throwing:将抛出的异常绑定到增强方法中
 	 * 
 	 * After(value,argNames) 最终（final)增强
 	 * 无论是抛出异常还是正常退出，都会执行此增强
	 */
	/*@Before("execution(public String com.spring.aspectjAnnotation.Target.speak(Integer))")
	public void before(JoinPoint joinPoint) {
		System.out.println("前置日志记录： "
                + ((Target) joinPoint.getTarget()).getName() + "调用了"
                + joinPoint.getSignature().getName() + "方法,传入参数为："
                + joinPoint.getArgs()[0]);
	}*/
	
	/**
	 * 方法切点函数
	 * execution(* com.yc.service.*.*(..))在配置service层的事务管理时常用，定位于任意返回类型（第一个"*") 
	 * 在com.yc.service包下的所有类（第二个"*")下的所有方法（第三个"*"),且这个方法的入参为任意类型、数量（体现在 "(..)"）
	 * 
	 * execution(<修饰符> <返回类型> <类路径> <方法名>(<参数列表>) <异常模式>
	 * 1. 通过方法签名、返回值定义切点：
	 * execution(public * *Service(..))`：定位于所有类下返回值任意、方法入参类型、数量任意，public类型的方法
	 * execution(public String *Service(..))`：定位于所有类下返回值为String、方法入参类型、数量任意，public类型的方法
	 * 2. 通过类包定义切点：
	 * execution(* com.yc.controller.BaseController+.*(..))`:匹配任意返回类型，对应包下BaseController类及其子类等任意方法。
	 * execution(* com.*.(..))`:匹配任意返回类型，com包下所有类的所有方法
	 * execution(* com..*.(..))`:匹配任意返回类型，com包、子包下所有类的所有方法
	 * 注意.表示该包下所有类，..则涵括其子包。
	 * 3. 通过方法入参定义切点
	 * 这里“\*”表示任意类型的一个参数，“..”表示任意类型任意数量的参数
	 * execution(* speak(Integer,*))`:匹配任意返回类型，所有类中只有两个入参，第一个入参为Integer，第二个入参任意的方法
	 * execution(* speak(..,Integer,..))`:匹配任意返回类型，所有类中至少有一个Integer入参，但位置任意的方法。
	 */
	
	/**
	 *  同一切面中，不同增强的织入顺序为：环绕增强前半部分->前置增强->原目标函数调用->环绕增强后半部分->最终增强->后置增强
	 *  没有实现order接口的“优先级”总是低于实现了order接口
	 *  多个同一类型的增强（如都是前置增强）对同一连接点的织入顺序是：
	 *  配置有优先级看谁优先级高，优先级相同则看谁先在IOC容器注册，配置了order接口或注释的增强优先级总是高于没配置的
	 */
	
	/**
	 * 可以在增强方法中绑定入参org.aspectj.lang.JoinPoint
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("execution(public String com.spring.aspectjAnnotation.Target.speak(Integer))")
    public void before(JoinPoint joinPoint) throws Throwable {
        System.out.println("前置日志记录： "
                + ((Target) joinPoint.getTarget()).getName() + "调用了"
                + joinPoint.getSignature().getName() + "方法,传入参数为："
                + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getTarget());//获取目标对象
        System.out.println(joinPoint.getThis());//获取目标对象
        System.out.println(joinPoint.getArgs());//获取目标对象方法入参
        System.out.println(joinPoint.getClass());
        System.out.println(joinPoint.getSignature());//获取完整的方法签名
        System.out.println(joinPoint.getSourceLocation());
        System.out.println(joinPoint.getStaticPart());//获取切点定位信息
    }
}
