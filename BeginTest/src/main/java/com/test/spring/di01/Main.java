package com.test.spring.di01;

public class Main {
	public static void main(String[] args) {
		
		//의존 관계
		//Main > (의존) > Hong > Pen
		
		//의존 관계를 만드는 방법!!1
		//1. 기존 방법
		//2. DI 패턴 방법
		
		
		//Main.main() 실행 > Hong에게 업무 위임
		
		//Main의 의존 객체(Dependency Object)
		
		//의존 객체를 직접 생성한다. > 기본 방법
		Hong hong = new Hong();
		hong.run();
		
		
//		Lee lee = new Lee();
//		lee.run();
		
		Brush brush = new Brush(); // Main 객체가 필요로 하는 객체가 아니다.(***)
		
		Lee lee = new Lee(brush); //DI 발생, 의존 주입 발생!!
		lee.run();
		
		
	}
}
