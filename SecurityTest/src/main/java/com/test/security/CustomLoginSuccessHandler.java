package com.test.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		// 방금 로그인 한 사람이 어떤 자격을 가지고 있는지?
		// - 일반 회원 or 관리자
		List<String> roleNames = new ArrayList<>();

		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});

		System.out.println(roleNames);

		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/spring/admin/admin.do");
		} else if (roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/spring/member/member.do");
		} else {
			response.sendRedirect("/spring/index.do");
		}
	}

}
