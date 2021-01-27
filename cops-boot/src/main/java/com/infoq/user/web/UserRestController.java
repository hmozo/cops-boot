package com.infoq.user.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infoq.infrastructure.security.ApplicationUserDetails;
import com.infoq.user.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	private final UserService service;
	
	public UserRestController(UserService service) {
		this.service= service;
	}
	
	public UserDto currentUser(@AuthenticationPrincipal ApplicationUserDetails userDetails) {
		service
	}
	
}
