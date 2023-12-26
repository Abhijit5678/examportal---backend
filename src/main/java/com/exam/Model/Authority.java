package com.exam.Model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	private String authrity;
	
	public Authority(String authrity) {
		this.authrity=authrity;
	}
	
	@Override
	public String getAuthority() {
		return this.authrity;
	}

}
