package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.test.domain.AddressDTO;

public interface AddressMapper {
	
	@Select("select * from tblAddress")
	List<AddressDTO> list();
	
	AddressDTO get();
}
