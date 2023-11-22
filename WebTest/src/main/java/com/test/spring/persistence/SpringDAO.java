package com.test.spring.persistence;

import com.test.spring.domain.SpringDTO;

public interface SpringDAO {
	
	int getCount();

	int add(SpringDTO dto);
	
}
