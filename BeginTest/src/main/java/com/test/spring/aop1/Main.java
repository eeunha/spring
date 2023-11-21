package com.test.spring.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		// 주업무 객체 > 스프링 환경을 제공받기 못한다.
//		Memo memo = new MemoImpl();

		// 스프링 혜택 적용 > 반드시 객체를 스프링을 통해서 생성해야 한다.
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/spring/aop1/memo.xml");

		Memo memo = (Memo) context.getBean("memo"); // new MemoImpl();

		memo.add("스프링 AOP");

		try {
			String txt = memo.read(15);
			System.out.println(txt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		memo.edit(5, "수정합니다.");

		memo.del(5);

	}
}
