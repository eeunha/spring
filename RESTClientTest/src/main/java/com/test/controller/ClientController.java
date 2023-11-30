package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

	@GetMapping(value = "/list.do")
	public String list(Model model) {

		return "list";
	}

	@GetMapping(value = "/add.do")
	public String add(Model model) {

		return "add";
	}

	@GetMapping(value = "/view.do")
	public String view(Model model, String seq) {

		model.addAttribute("seq", seq);

		return "view";
	}
}
