package com.test.persistence;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.domain.AddressDTO;

@Repository
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	private SqlSessionTemplate template;

	@Override
	public int add(AddressDTO dto) {

		return template.insert("rest.add", dto);
	}
}
