package com.test.domain;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {
	private String userid;
	private String userpw;
	private String username;
	private String regdate;
	private boolean enabled;

	private List<AuthDTO> authlist;
}
