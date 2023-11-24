package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.CodeDTO;
import com.test.persistence.CodeDAO;

@org.springframework.stereotype.Controller
public class CodeController {

	@Autowired
	private CodeDAO dao;

	@GetMapping(value = "/add.do")
	public String add() {

		return "add";
	}

	@PostMapping(value = "/addok.do")
	public String addok(CodeDTO dto) {

		int result = dao.add(dto);

		if (result == 1) {
			return "redirect:/list.do";
		} else {
			return "redirect:/add.do";
		}
	}

	@GetMapping(value = "/list.do")
	public String list(@RequestParam(name = "language", required = false) List<String> language, Model model) {

		// list.do
		// list.do?language=java&
		// list.do?language=java&language=css

		// -> 똑같은 값을 여러개 받으면 배열로 받으면 된다.
		// -> List<String>

		//@RequestParam(name = "language", required = false) List<String> language
		//language가 넘어가지 않았을 경우 오류가 나기 때문에 위에처럼 추가작성해준다.
		
		System.out.println(language);
		
		List<CodeDTO> list = dao.list(language);

		model.addAttribute("list", list);
		model.addAttribute("language", language);

		return "list";
	}

	@GetMapping(value = "/view.do")
	public String view(String seq, Model model) {

		CodeDTO dto = dao.get(seq);

		model.addAttribute("dto", dto);

		return "view";
	}
}
