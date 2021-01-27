package com.infoq.infrastructure.security;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;

import com.infoq.config.AppConfig;
import com.infoq.config.TestConfig;
import com.infoq.user.UserRepository;
import com.infoq.user.Users;

import org.mockito.ArgumentMatchers.*;


@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
class ApplicationUserDetailsServiceTest {

	@MockBean
	UserRepository userRepository;
	
	@Test
	void shouldReturnUserGivenExistingUsername() {
		ApplicationUserDetailsService service= new ApplicationUserDetailsService(userRepository); 
		when(userRepository.findByEmailIgnoreCase(Users.OFFICER_EMAIL))
			.thenReturn(Optional.of(Users.officer()));
		
		UserDetails userDetails= service.loadUserByUsername(Users.OFFICER_EMAIL);
		
		assertNotNull(userDetails);
		assertThat(userDetails.getUsername()).isEqualTo(Users.OFFICER_EMAIL);
		//assertThat(userDetails.getAuthorities()).extracting(GrantedAuthority::getAuthority)
		assertThat(userDetails).isInstanceOfSatisfying(ApplicationUserDetails.class, aud->assertThat(aud.getUserId()).isEqualTo(Users.officer().getId()));
	}
	
	@Test
	void shouldThrowExceptionWhenLoadingUserGivenNotExistingUsername(){
		ApplicationUserDetailsService service= new ApplicationUserDetailsService(userRepository); 
		when(userRepository.findByEmailIgnoreCase(ArgumentMatchers.anyString())).thenReturn(Optional.empty());
		Throwable throwable= assertThrows(UsernameNotFoundException.class, ()->service.loadUserByUsername("i@donotexist.com"));
		assertEquals("", throwable.getMessage());
	}

}
