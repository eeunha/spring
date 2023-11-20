package com.test.spring.di02;

public class Park {

	private Choi choi;

	public Park(Choi choi) {
		this.choi = choi;
	}

	public void run() {

		System.out.println("Park 업무 중...");

		choi.doSomething();
		
	}
}
