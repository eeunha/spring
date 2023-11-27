package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	@GetMapping(value = "/info.do")
	public String info(Model model) {

		return "member/info";
	}
	
	@GetMapping(value = "/history.do")
	public String history(Model model) {

		return "member/history";
	}
	
	@GetMapping(value = "/favorite.do")
	public String favorite(Model model) {

		return "member/favorite";
	}
}
