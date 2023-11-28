package com.test.file.model;

import java.util.List;

public interface FileDAO {

	int add(PlaceDTO dto);

	List<PlaceDTO> list();

	PlaceDTO get(String seq);

}
