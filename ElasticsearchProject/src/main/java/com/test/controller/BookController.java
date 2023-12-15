package com.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.BookDTO;
import com.test.persistence.BookDAO;
import com.test.persistence.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookDAO dao; // 오라클 담당자

	@Autowired
	private BookRepository repo; // 엘라스틱서치 담당자

	// 목록보기
	@GetMapping(value = "/list.do")
	public String list(Model model, String word) {

		if (word == null || word.equals("")) {
			// 검색(X) > 목록보기 > 오라클 조회
			List<BookDTO> list = dao.list();
			model.addAttribute("list", list);

		} else {
			// 검색(O) > 검색하기 > 엘라스틱서치 조회
			List<Map<String, Object>> list = repo.search(word);
			model.addAttribute("word", word);
			model.addAttribute("list", list); // 오라클과 엘라스틱서치의 컬럼명이 같아서 동일한 메소드로 사용 가능
		}

		return "list";
	}

	// 추가하기(폼)
	@GetMapping(value = "/add.do")
	public String add(Model model) {

		return "add";
	}

	// 추가하기(처리)
	@PostMapping(value = "/addok.do")
	public String addok(Model model, BookDTO dto) {

		dao.add(dto); // DB > seq 발생
		
		String seq = dao.getSeq();
		dto.setSeq(seq);
		
		repo.add(dto);	//ES

		return "redirect:/list.do";
	}

	// 상세보기
	@GetMapping(value = "/view.do")
	public String view(Model model, String seq) {

		BookDTO dto = dao.get(seq);

		model.addAttribute("dto", dto);

		return "view";
	}

}
