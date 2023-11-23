package com.test.persistence;

import com.test.domain.MyBatisDTO;

public interface MyBatisDAO {
	
	void test();

	int add(MyBatisDTO dto);
	
}
