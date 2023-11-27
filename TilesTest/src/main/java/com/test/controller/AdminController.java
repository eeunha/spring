package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping(value = "/log.do")
	public String log(Model model) {

		return "admin.log";
	}

	@GetMapping(value = "/setting.do")
	public String setting(Model model) {

		return "admin.setting";
	}
}
