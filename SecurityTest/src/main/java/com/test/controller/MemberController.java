package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.AuthDTO;
import com.test.domain.MemberDTO;
import com.test.mapper.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private MemberMapper mapper; // 원래는 dao를 거쳐서 mapper를 불러야 한다. 하지만 수업 편의상 바로 부르겠다.

	@GetMapping(value = "/auth/register.do")
	public String register(Model model) {

		return "auth/register";
	}
	
	@PostMapping(value = "/auth/registerok.do")
	public String registerok(Model model, MemberDTO dto, int auth) { //dto에는 auth가 없어서 따로 받는다.

		//암호 인코딩
		dto.setUserpw(encoder.encode(dto.getUserpw()));
		
		//tblMember 추가
		int result = mapper.add(dto);
		
		if (auth >= 1) {
			AuthDTO adto = new AuthDTO();
			adto.setUserid(dto.getUserid());
			adto.setAuth("ROLE_MEMBER");
			mapper.addAuth(adto);
		}
			
		if (auth >= 2) {
			AuthDTO adto = new AuthDTO();
			adto.setUserid(dto.getUserid());
			adto.setAuth("ROLE_ADMIN");
			mapper.addAuth(adto);
		}
		
		return "redirect:/index.do"; // 바로 경로 이동시킨다.
	}
}
