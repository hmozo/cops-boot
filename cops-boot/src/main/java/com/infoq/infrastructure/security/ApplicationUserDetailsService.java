package com.infoq.infrastructure.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.infoq.user.User;
import com.infoq.user.UserRepository;

@Component
public class ApplicationUserDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	public ApplicationUserDetailsService(UserRepository userRepository) {
		this.userRepository= userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepository.findByEmailIgnoreCase(username)
			.orElseThrow(()-> new UsernameNotFoundException(String.format(
					"User with email %s could not be found", username)));
		return new ApplicationUserDetails(user);
	}

}
