package com.test.spring.domain;

import lombok.Data;

@Data
public class SpringDTO {

	private String name;
	private String age;
	private String address;

	//연관없는 변수도 dto에 저장 가능하지만 그냥 매개변수로 바로 받자.
//	private String seq;
}
