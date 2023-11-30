package com.test.persistence;

import java.util.List;

import com.test.domain.AddressDTO;

public interface AddressDAO {

	int add(AddressDTO dto);

	List<AddressDTO> list();

	int edit(AddressDTO dto);

	int del(String seq);

	AddressDTO get(String seq);

}
