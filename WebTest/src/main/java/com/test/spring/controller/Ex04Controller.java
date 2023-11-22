package com.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value = "/ex04.do")
public class Ex04Controller {

	@RequestMapping(value="/ex04.do")
	public String ex04() {

		return "ex04";
	}

	@RequestMapping(value="/ex04_1.do")
	public String ex04_1() {

		return "ex04_1";
	}
}
