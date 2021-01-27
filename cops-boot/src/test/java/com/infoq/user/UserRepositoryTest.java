package com.infoq.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import com.infoq.config.TestConfig;


@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	void shouldBeSavedUser() {
		Set<UserRole> roles= new HashSet<>();
		roles.add(UserRole.OFFICER);
		User userToSave= new User(
				repository.nextId(), 
				"alex.foley@beverly-hills.com",
				"my-secret-pwd",
				roles);
		
		User user= repository.save(userToSave);
		
		assertNotNull(user);
		assertEquals(repository.count(), 1L);
	}
	
	@Test
	void shouldFindUserByEmail() {
		User user= Users.newRandomOfficer();
		repository.save(user);
		
		Optional<User> optional= repository.findByEmailIgnoreCase(user.getEmail());
		
		assertThat(optional).isNotEmpty().contains(user);
	}
	
	@Test
	void shouldFindUserByEmailIgnoringCase() {
		User user= Users.newRandomOfficer();
		repository.save(user);
		
		Optional<User> optional= repository.findByEmailIgnoreCase(user.getEmail().toUpperCase());
		
		assertThat(optional).isNotEmpty().contains(user);
	}
	
	@Test
	void shouldNotFindUserByEmail_unknownEmail() {
		User user= Users.newRandomOfficer();
		repository.save(user);
		
		Optional<User> optional= repository.findByEmailIgnoreCase("will.not@find.me");
		
		assertThat(optional).isEmpty();
	}
	
	
	
	
}
