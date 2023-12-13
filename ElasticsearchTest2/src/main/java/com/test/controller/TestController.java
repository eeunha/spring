package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {
	
	//목록보기
	@GetMapping(value = "/list.do")
	public String list(Model model) {

		return "list";
	}
	
	//추가하기(폼)
	@GetMapping(value = "/add.do")
	public String add(Model model) {

		return "add";
	}
	
	//추가하기(처리)
	@PostMapping(value = "/addok.do")
	public String addok(Model model) {

		return "addok";
	}
}
