package com.test.spring.di01;

public class Hong {

	public void run() {

		//의존 관계
		//Main > Hong > (의존) > Pen
		
		//펜을 사용하는 업무 > 펜 객체 생성 > 사용(위임)
		
		//Hong의 의존 객체이다. > Pen을 직접 생성한다.
		Pen p = new Pen();
		p.write();
		
	}

}
