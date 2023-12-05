package com.test.mapper;

import com.test.domain.AuthDTO;
import com.test.domain.MemberDTO;

public interface MemberMapper {

	public int add(MemberDTO dto);

	public void addAuth(AuthDTO adto);

	public MemberDTO read(String username);

}
