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

//		return "info"; //<definition name="*">
		return "member.info"; //<definition name="*.*">  단어를 .기준으로 각각 받을 수 있음
	}
	
	@GetMapping(value = "/history.do")
	public String history(Model model) {

//		return "history";
		return "member.history";
	}
	
	@GetMapping(value = "/favorite.do")
	public String favorite(Model model) {

//		return "favorite";
		return "member.favorite";
	}
}
