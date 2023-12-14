package com.test.persistence;

import java.util.List;

import com.test.domain.BookDTO;

public interface BookDAO {

	List<BookDTO> list();

	BookDTO get(String seq);

	void add(BookDTO dto);

}
