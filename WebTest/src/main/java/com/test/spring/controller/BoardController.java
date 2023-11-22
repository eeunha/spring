package com.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board") // 중복 주소는 이렇게 적어서 줄일 수 있다.
public class BoardController {

	// - "/spring/board/list.do"
	// - "/spring/board/add.do"
	// - "/spring/board/addok.do"
	// - "/spring/board/view.do"

	// - doGet(), doPost() 역할
	@RequestMapping(value = "/list.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String list() {

		return "board/list";
	}

	// - doGet() 역할
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String add() {

		return "board/add";
	}

	// - doPost() 역할
//	@RequestMapping(value = "/board/addok.do", method = RequestMethod.GET) // HTTP 상태 405 – 허용되지 않는 메소드  Request method 'POST' not supported
	@RequestMapping(value = "/addok.do", method = RequestMethod.POST)
	public String addok() {

		return "board/addok";
	}

	// - doGet() 역할
	@RequestMapping(value = "/view.do", method = RequestMethod.GET)
	public String view() {

		return "board/view";
	}
}
