package com.test.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 구현
//1. Controller 인터페이스 구현
//2. @Controller 어노테이션 사용

//1. Controller 인터페이스 구현
//public class Ex03Controller implements Controller {
//
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		return null;
//	}
//
//}


//http://localhost:8090/spring/ex03.do
//2. @Controller 어노테이션 사용
@Controller
@RequestMapping(value="/ex03.do")  // = @WebServlet("/ex03.do")  servlet-context.xml에 작성하지 않고 어노테이션으로 가능하다. 띄어쓰기는 자유
public class Ex03Controller {

	//요청 메서드(doGet/doPost/handleRequest) 없음 > 맘대로 만들어라.
	//== 핸들러
	@RequestMapping  //요청이 들어왔을 때 자동으로 호출되는 요청 메소드임을 알린다. 응답메소드에만 붙이기. 딱 하나의 메소드에만 붙이기
	public String test() {
		
		//업무 코드
		
		//JSP 호출하기
		
		//1. ModelAndView 생성
		//2. ViewResolver 동작
		
		return "ex03"; //jsp 파일 이름 적기. 해당 파일로 넘어감 => "/WEB-INF/views/ex03.jsp"
	}
	
	//Ambiguous mapping found. Cannot map 'ex04Controller' bean method 
	//@RequestMapping
	public int sum(int a, int b) {
		
		return a + b;
	}
}
