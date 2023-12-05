package com.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.test.domain.CustomUser;
import com.test.domain.MemberDTO;
import com.test.mapper.MemberMapper;

//모든 계정 정보 관리
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// DB상에서 회원 정보 읽어서 > 인증 객체 대입
		// ex)세션 정보 읽기

		// username == 아이디
		MemberDTO dto = mapper.read(username);

		// MemberDTo > 시큐리티에서 사용(변환) > CustomUser (인증 객체)

		return dto != null ? new CustomUser(dto) : null;
	}

}
