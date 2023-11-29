package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.AddressDTO;
import com.test.persistence.AddressDAO;

//@RestController > 요청 메서드의 반호나값에 자동으로 @ResponseBody가 적용된다.
@RestController
public class RESTController {

	@Autowired
	private AddressDAO dao;

	//CRUD + REST
	
	//추가하기
	//1. http://localhost:8090/rest/address
	//2. POST
	//3. return int
	
//	@RequestMapping(value="/address", method=RequestMethod.POST)
	@PostMapping(value="/address")
//	public int add(AddressDTO dto) { //Postman에서 Param으로 넘길 때 사용
		public int add(@RequestBody AddressDTO dto) { //@RequestBody > JSON으로 받기 => Postman에서 json으로 보낼 때 사용
		
		return dao.add(dto);
	}
	
}
