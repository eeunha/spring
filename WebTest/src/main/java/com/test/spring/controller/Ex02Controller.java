package com.test.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.spring.persistence.SpringDAO;

public class Ex02Controller implements Controller {
	
	//1. 변수 생성
	private SpringDAO dao;

	//2. 주입도구 만들기
	public Ex02Controller(SpringDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Ex02Controller 객체 > (의존) > SpringDAO 객체
		
		//업무 중 일부 > DB 작업 > DAO 위임
//		SpringDAO dao = new SpringDAOImpl();
		
		int count = dao.getCount();

		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("count", count);
		mv.setViewName("ex02");
		
		return mv;
	}
	
}
