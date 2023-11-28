package com.test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //bean으로 등록
@Aspect //보조 업무 객체. 아이콘에 s가 없다 -> bean이 아니다. 단순한 역할만 부여한다.
public class Log {
	
	//포인트컷 > 주업무 메소드 > AspectJ 표현식
	@Pointcut("execution(* com.test.controller.AOPController.add(..))") //하나의 add() 가리킨다
	public void pc1() {
		//구현부 없음
	}
	
	//보조 업무
	@After("pc1()") //위와 연결
	public void m1() {
		System.out.println("[보조업무] 기록을 남깁니다.");
	}
	
	@Before("pc1()") //위와 연결
	public void m2() {
		System.out.println("Before Advice");
	}
	
	@After("execution(* com.test.controller.AOPController.list(..))")
	public void m3() {
		System.out.println("보조 업무");
	}
	
	//글쓰기, 수정하기, 삭제하기 > 권한 체크(보조업무. AOP 사용하면 편리하다.)
	
}
