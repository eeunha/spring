package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.AddressDTO;
import com.test.persistence.AddressDAO;

//@RestController > 요청 메서드의 반호나값에 자동으로 @ResponseBody가 적용된다.
@RestController
public class RESTController {

	@Autowired
	private AddressDAO dao;

	// CRUD + REST

	// 추가하기
	// 1. http://localhost:8090/rest/address
	// 2. POST
	// 3. return int
//	@RequestMapping(value="/address", method=RequestMethod.POST)
	@PostMapping(value = "/address")
//	public int add(AddressDTO dto) { //Postman에서 Param으로 넘길 때 사용
	public int add(@RequestBody AddressDTO dto) { // @RequestBody > JSON으로 받기 => Postman에서 json으로 보낼 때 사용

		return dao.add(dto);
	}

	// 목록보기
	// 1. http://localhost:8090/rest/address
	// 2. GET
	// 3. return List<DTO>
	@GetMapping(value = "/address")
	public List<AddressDTO> list() {

		return dao.list();
	}

	// 수정하기
	// 1. http://localhost:8090/rest/address/1
	// 2. PUT or PATCH
	// 3. return int
	// @RequestMapping(value="/address/{seq}", method=RequestMethod.PUT) //경로
	// 변수(PathVariable)
	@PutMapping(value = "/address/{seq}")
	public int edit(@RequestBody AddressDTO dto, @PathVariable String seq) {

//		System.out.println(dto.getSeq());
//		System.out.println(seq);
//		System.out.println();

		dto.setSeq(seq); // 처음에 seq가 비어있어서 등록하는 과정이 필요하다.

		return dao.edit(dto);
	}

	// 삭제하기
	// 1. http://localhost:8090/rest/address/1
	// 2. DELETE
	// 3. return int
	@DeleteMapping(value = "/address/{seq}")
	public int del(@PathVariable("seq") String seq) {

		return dao.del(seq);
	}

	// 검색하기(=상세보기)
	// 1. http://localhost:8090/rest/address/1
	// 2. GET
	// 3. return DTO
	@GetMapping(value = "/address/{seq}")
	public AddressDTO get(@PathVariable("seq") String seq) {

		return dao.get(seq);
	}

}
