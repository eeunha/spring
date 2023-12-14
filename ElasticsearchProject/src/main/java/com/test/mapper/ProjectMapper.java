package com.test.mapper;

import java.util.List;

import com.test.domain.BookDTO;

public interface ProjectMapper {

	List<BookDTO> list();

	BookDTO get(String seq);

	void add(BookDTO dto);

}
