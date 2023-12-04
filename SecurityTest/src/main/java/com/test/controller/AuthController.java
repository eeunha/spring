package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping(value = "/auth/accesserror.do")
	public String accesserror(Model model) {

		// 권한이 없는 페이지를 접근하면 대신 보여줄 페이지
		return "auth/accesserror";
	}

	@GetMapping(value = "/auth/mylogin.do")
	public String mylogin(Model model) {

		return "auth/mylogin";
	}

	@GetMapping(value = "/auth/mylogout.do")
	public String mylogout(Model model) {

		return "auth/mylogout";
	}
}
