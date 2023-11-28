package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.persistence.AOPDAO;

@Controller
public class AOPController {
	
	@Autowired
	private AOPDAO dao;
	
	//주업무 구현
	
	//목록보기
	@GetMapping(value = "/list.do")
	public String list(Model model) {

		dao.list();
		System.out.println("Controller.list()");
		
		return "list";
	}
	
	//글쓰기
	@GetMapping(value = "/add.do")
	public String add(Model model) {
		dao.add();
		System.out.println("Controller.add()");
		
		return "add";
	}
	
	//상세보기
	@GetMapping(value = "/view.do")
	public String view(Model model) {
		dao.view();
		System.out.println("Controller.view()");
		
		return "view";
	}
}
