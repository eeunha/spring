package com.test.spring.persistence;

import com.test.spring.domain.SpringDTO;

public class SpringDAOImpl implements SpringDAO {

	@Override
	public int getCount() {

		return 100; // select..
	}

	@Override
	public int add(SpringDTO dto) {
		
		//DB > insert
		System.out.println("insert 완료");
		System.out.println(dto);
		
		return 1;
	}

}
