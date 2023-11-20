package com.test.spring.di02;

public class Hong {

	// 의존 주입 구현
	// 1. 의존 객체 > 멤버 변수 만들기
	// 2. 의존 주입 도구 만들기 > 생성자 or setter

	private Pen p;

	public Hong(Pen p) {
		this.p = p;
	}

	public void run() {

		// 3. 의존 객체를 사용하기
		p.write();

	}

}
