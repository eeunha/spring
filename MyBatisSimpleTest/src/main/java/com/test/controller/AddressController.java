package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.mapper.AddressMapper;

@Controller
public class AddressController {
	
	@Autowired
	private AddressMapper mapper;
	
	@GetMapping(value = "/list.do")
	public String list(Model model) {

		model.addAttribute("list", mapper.list());
		model.addAttribute("dto", mapper.get());
		
		return "list";
	} 
	
	
}
