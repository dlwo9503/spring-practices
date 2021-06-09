package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))")
	// ""안에는 포인트컷을 기술해 줘야 함 (어디에서), execution은 실행, 메소드의 리턴 타입도 앞에 기술해줘야 함
	// 패키지 이름에, 파일 이름에, 메소드 이름에, 타입까지 적어줘야 함
	public void beforeAdvice() { // 어떤 메소드가 실행되기 전에 advice를 실행
		System.out.println("---Before Advice---");
	}

	@After("execution(* *..*.service.ProductService.*(..))")
	// 와일드카드 * 사용, *..*를 사용하면 하나 이상 생략가능, 아규먼트는 ..
	public void afterAdvice() {
		System.out.println("---After Advice---");
	}

	@AfterReturning("execution(* *..*.ProductService.*(..))")
	// 와일드카드 * 사용, *..*를 사용하면 하나 이상 생략가능, 아규먼트는 ..
	public void afterReturningAdvice() {
		System.out.println("---After Returning Advice---");
	}

	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing="ex")
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("---After Throwing Advice:" + ex + "---");
	}
	
	@Around("execution(* *..*.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		// Before Advice
		System.out.println("@Around(Before) Advice");
		
		// PointCut Method 실행
		
		// 파라미터 가로채기(바꿔버리기)
		// Object[] params = {"Camera"};
		// Object result = pjp.proceed(params);
		
		Object result = pjp.proceed();
		
		// After Advice
		System.out.println("@Around(After) Advice");
		
		return result;
	}

}
