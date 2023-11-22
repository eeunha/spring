package com.test.spring.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ex05Controller {

//	@RequestMapping(value = "/ex05.do", method = RequestMethod.GET)
//	public String ex05() {
//
//		// 데이터 입력 폼
//
//		return "ex05";
//	}
//
//	@RequestMapping(value = "/ex05ok.do", method = RequestMethod.POST)
//	public String ex05ok() {
//
//		return "ex05ok";
//	}

//	@RequestMapping(value = "/ex05.do", method = RequestMethod.GET)
	@GetMapping(value = "/ex05.do")
	public String ex05() {

		return "ex05";
	}

	// servlet 방식
//	@RequestMapping(value = "/ex05ok.do", method = RequestMethod.POST)
//	@PostMapping(value = "/ex05ok.do")
//	public String ex05ok(HttpServletRequest req, HttpServletResponse resp, HttpSession session) { //매개변수 순서 바뀌어도 된다. 
//
//		//데이터 수신
//		//- Servlet/JSP: req.getParameter(), req.getParameterValues()
//		//- Spring: 매개변수로 req 호출. resp도 마찬가지.
//		
////		System.out.println(req == null);
////		System.out.println(resp == null);
////		System.out.println(session == null);
//		
//		String data = req.getParameter("data");
//		
//		req.setAttribute("data", data);
//		
//		return "ex05ok";
//	}

	// Spring 방식
//	@PostMapping(value = "/ex05ok.do")
////	public String ex05ok(@RequestParam("data") String data) { // 생략 가능
//	public String ex05ok(@RequestParam(name = "data") String data, Model model) { // ModelAndView의 Model. 일종의 DTO
//
//		//<input type="text" name="data"> -> 매개변수의 name과 동일
//		
//		// String data = req.getParameter("data");
//		
////		System.out.println(data);
//
//		//req.setAttribute("data", data);
//		model.addAttribute("data", data);
//
//		return "ex05ok";
//	}

	// upgrade 버전
//	@PostMapping(value="/ex05ok.do")
//	public String ex05ok(String data, Model model) { // jsp의 name과 동일한 변수명일 경우 어노테이션 생략 가능
//		
//		model.addAttribute("data", data);
//		
//		return "ex05ok";
//	}

	// 매개변수 어노테이션 작성
//	@PostMapping(value="/ex05ok.do")
//	public String ex05ok(@RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("address") String address, Model model) { 
//		
//		SpringDTO dto = new SpringDTO();
//		
//		dto.setName(name);
//		dto.setAge(age);
//		dto.setAddress(address);
//		
//		SpringDAO dao = new SpringDAOImpl();
//		
//		int result = dao.add(dto);
//		
//		model.addAttribute("result", result);
//		
//		return "ex05ok";
//	}

	// 어노테이션 생략
//	@PostMapping(value="/ex05ok.do")
//	public String ex05ok(String name, String age, String address, Model model) { 
//		//@RequestParam(name="address")
//		//장기 프로젝트는 풀네임 다 적기 (6개월~)  가독성 좋음
//		//개인 프로젝트는 간단하게 적기
//		
//		SpringDTO dto = new SpringDTO();
//		
//		dto.setName(name);
//		dto.setAge(age);
//		dto.setAddress(address);
//		
//		SpringDAO dao = new SpringDAOImpl();
//		
//		int result = dao.add(dto);
//		
//		model.addAttribute("result", result);
//		
//		return "ex05ok";
//	}

	// DTO로 매개변수 해결
//	@PostMapping(value = "/ex05ok.do")
//	public String ex05ok(SpringDTO dto, @RequestParam("seq") String seq, Model model) { // jsp의 name과 dto의 변수명 같게 하기 =>
//																						// dto로 자동인식
//
//		SpringDAO dao = new SpringDAOImpl();
//
//		int result = dao.add(dto);
//
//		System.out.println(seq);
//		
//		model.addAttribute("result", result);
//
//		return "ex05ok";
//	}

//	@PostMapping(value = "/ex05ok.do")
//	public String ex05ok(Model model, HttpServletRequest req) {
//		
//		String[] cb = req.getParameterValues("cb");
//		
//		System.out.println(Arrays.toString(cb));
//		
//		
//		return "ex05ok";
//	}

//	@PostMapping(value = "/ex05ok.do")
//	public String ex05ok(Model model,
////			@RequestParam("cb") String[] cb
//			String[] cb) {
//
//		System.out.println(Arrays.toString(cb));
//
//		return "ex05ok";
//	}
	
	//바로 넘겨줌
	@PostMapping(value="/ex05ok.do")
	public String ex05ok(@ModelAttribute(name="data") String data) {
		
		return "ex05ok";
	}
}
