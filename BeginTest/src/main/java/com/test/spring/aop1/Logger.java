package com.test.spring.aop1;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

//보조 업무 객체
public class Logger {

	// 보조 업무 구현
	public void log() {
		Calendar now = Calendar.getInstance();
		System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\r", now, now);
	}

	public void time(ProceedingJoinPoint jp) {

		// 주업무를 실행하는 소요시간

		long begin = System.nanoTime();
		System.out.println("[LOG] 기록을 시작합니다.");

		// 주업무 실행
		// - 글쓰기 > 주업무 객체의 가상 객체 참조
		try {

			jp.proceed(); // memo.add(), memo.read(), memo.edit() -> 붙여둔 메소드가 된다. 스프링이 지정함

		} catch (Throwable e) {
			// TODO: handle exception
		}

		long end = System.nanoTime();
		System.out.println("[LOG] 기록을 종료합니다.");

		System.out.printf("[LOG] 소요 시간 %,dns\n", end - begin);
	}

	public void history(String memo) {

		System.out.println("[LOG] 읽기 기록 > " + memo);

	}

	public void check(Exception e) {
		
		System.out.println("[LOG] 예외 발생: " + e.getMessage());
		
		//관리자(담당자)에게 연락
		
		
	}
}
