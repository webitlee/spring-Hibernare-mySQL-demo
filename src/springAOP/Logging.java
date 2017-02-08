package springAOP;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
	//前置通知
	@Before("execution(* springAOP.Calc.add(int, int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("先执行我,然后再执行" + methodName + "方法,参数为：" + args);
	}
	
	//后置通知
	@After("execution(* springAOP.Calc.minus(..))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("先执行" + methodName + "方法，再执行我，参数为：" + args);
	}
	
	//返回通知
	@AfterReturning(value="execution(* springAOP.Calc.mod(..))", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("我是返回通知，返回值为：" + result + " 方法名为：" + methodName);
	}
	
	//环绕通知
	@Around("execution(* springAOP.Calc.div(..))")
	public Object aroundMethod(ProceedingJoinPoint pjp){
		Object result = null;
		try{
			//前置通知
			System.out.println("我是前置通知");
			result = pjp.proceed();
			//返回通知
			System.out.println("我是返回通知");
		}catch(Throwable e){
			//异常通知
			System.out.println("我是异常通知" + e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("我是后置通知");
		return result;
	}
	
}
