package com.test.persistence;

import java.util.List;
import java.util.Map;

import com.test.domain.BookDTO;

public interface BookRepository {

	List<Map<String, Object>> search(String word);

	void add(BookDTO dto);

}
