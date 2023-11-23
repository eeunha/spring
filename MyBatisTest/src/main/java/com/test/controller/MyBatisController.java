package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.MyBatisDTO;
import com.test.persistence.MyBatisDAO;

@Controller //내부에 @Component가 있다. 얘가 bean 인식한다
public class MyBatisController {

	//http://localhost:8090/mybatis/test.do
	
	@Autowired // = ( = new MyBatisDAOImpl();) 
	private MyBatisDAO dao;
	
	@GetMapping(value="/test.do")
	public String test() {
		
		System.out.println("test");
		
		//의존 객체 > Spring DI
//		MyBatisDAO dao = new MyBatisDAOImpl();
		
		dao.test();
		
		return "list";
	} //test
	
	@GetMapping(value="/add.do")
	public String add() {
		
		
		
		return "add";
	}
	
	@PostMapping(value="/addok.do")
	public String addok(MyBatisDTO dto, Model model) {
		
		int result = dao.add(dto);
		
		model.addAttribute("result", result);
		
		return "addok";
	}
}
