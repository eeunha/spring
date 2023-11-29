package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.domain.AddressDTO;

@Controller
public class AddressController {

	@GetMapping(value = "/m1.do")
	public @ResponseBody String m1(Model model) { // @ResponseBody -> return 안의 순수한 값만 전달

		String name = "Hong"; // [/WEB-INF/views/문자열.jsp]을(를) 찾을 수 없습니다.

		return name;
	}

	@GetMapping(value = "/m2.do")
	public @ResponseBody AddressDTO m2(Model model) {

		AddressDTO dto = new AddressDTO();

		dto.setSeq("1");
		dto.setName("홍길동");
		dto.setGender("m");
		dto.setAge("20");
		dto.setAddress("서울시 강남구 역삼동");
		dto.setRegdate("2023-11-29");

		return dto;
	}

	@GetMapping(value = "/m3.do")
	public @ResponseBody List<AddressDTO> m3(Model model) {

		List<AddressDTO> list = new ArrayList<>();
		
		AddressDTO dto = new AddressDTO();

		dto.setSeq("1");
		dto.setName("홍길동");
		dto.setGender("m");
		dto.setAge("20");
		dto.setAddress("서울시 강남구 역삼동");
		dto.setRegdate("2023-11-29");
		
		AddressDTO dto2 = new AddressDTO();

		dto2.setSeq("2");
		dto2.setName("아무개");
		dto2.setGender("f");
		dto2.setAge("25");
		dto2.setAddress("서울시 강남구 청담동");
		dto2.setRegdate("2023-11-29");
		
		list.add(dto);
		list.add(dto2);

		return list;
	}
}
