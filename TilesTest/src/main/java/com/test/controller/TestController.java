package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping(value = "/test.do")
	public String test(Model model) {

//		http://localhost:8090/tiles/test.do
		
		//- 기존 ViewResolver 삭제 > JSP 페이지명
		
		//- 새롭게 TilesViewResolver(가명) 추가 > definition명 이름을 말한다. -> xml에 있다.
		return "test";
	}
}
