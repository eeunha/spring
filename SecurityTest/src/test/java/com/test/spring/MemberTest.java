package com.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.domain.AuthDTO;
import com.test.domain.MemberDTO;
import com.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" }) // 읽을 xml 파일 명시
public class MemberTest {

	@Autowired
	private TestMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

//	@Test //얘가 있으면 자동 실행됨. 없으면 호출해야만 실행된다.
	public void testInsertMember() {

		MemberDTO dto1 = new MemberDTO();
		dto1.setUserid("dog");
		dto1.setUsername("강아지");
		dto1.setUserpw(encoder.encode("1111"));
		mapper.add(dto1);

		MemberDTO dto2 = new MemberDTO();
		dto2.setUserid("cat");
		dto2.setUsername("고양이");
		dto2.setUserpw(encoder.encode("1111"));
		mapper.add(dto2);

		MemberDTO dto3 = new MemberDTO();
		dto3.setUserid("lion");
		dto3.setUsername("사자");
		dto3.setUserpw(encoder.encode("1111"));
		mapper.add(dto3);

	}

	@Test
	public void testInsertAuth() {

		AuthDTO dto1 = new AuthDTO();
		dto1.setUserid("dog");
		dto1.setAuth("ROLE_MEMBER");
		mapper.addAuth(dto1);

		AuthDTO dto2 = new AuthDTO();
		dto2.setUserid("cat");
		dto2.setAuth("ROLE_MEMBER");
		mapper.addAuth(dto2);

		AuthDTO dto4 = new AuthDTO();
		dto4.setUserid("lion");
		dto4.setAuth("ROLE_MEMBER");
		mapper.addAuth(dto4);

		AuthDTO dto3 = new AuthDTO();
		dto3.setUserid("lion");
		dto3.setAuth("ROLE_ADMIN");
		mapper.addAuth(dto3);

	}
}
