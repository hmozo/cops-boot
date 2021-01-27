package com.infoq.infrastructure.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.infoq.user.User;
import com.infoq.user.UserId;
import com.infoq.user.UserRole;

public class ApplicationUserDetails extends org.springframework.security.core.userdetails.User{

	private static final String ROLE_PREFX= "ROLE_";
	
	private final UserId userId;
	
	public ApplicationUserDetails(User user) {
		super(user.getEmail(), user.getPassword(), createAuthorities(user.getRoles()));
		this.userId= user.getId();
	}

	public UserId getUserId() {
		return userId;
	}
	
	private static Collection<SimpleGrantedAuthority> createAuthorities(Set<UserRole> roles){
		return roles.stream()
				.map(userRole-> new SimpleGrantedAuthority(ROLE_PREFX + userRole.name()))
					.collect(Collectors.toSet());
	}
}
