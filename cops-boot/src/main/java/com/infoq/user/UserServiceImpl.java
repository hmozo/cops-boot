package com.infoq.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository= userRepository;
		this.passwordEncoder= passwordEncoder;
	}
	
	@Override
	public User createOfficer(String email, String password) {
		User user= User.createOfficer(userRepository.nextId(), email, passwordEncoder.encode(password));
		return userRepository.save(user);
	}

}
