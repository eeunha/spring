package com.test.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.domain.BookDTO;
import com.test.mapper.ProjectMapper;

@Repository
public class BookDAOImpl implements BookDAO{

	@Autowired
	private ProjectMapper mapper;
	
	@Override
	public List<BookDTO> list() {

		return mapper.list();
	}
	
	@Override
	public BookDTO get(String seq) {
		
		return mapper.get(seq);
	}
	
	@Override
	public void add(BookDTO dto) {

		mapper.add(dto);
	}
}
