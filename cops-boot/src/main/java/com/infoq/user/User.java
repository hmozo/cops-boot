package com.infoq.user;

import java.util.Set;
import java.util.UUID;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infoq.orm.jpa.AbstractEntity;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "copsboot_user")
@NoArgsConstructor
public class User extends AbstractEntity<UserId>{
		
	private String email;
	private String password;
	
	@ElementCollection(fetch= FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Set<UserRole> roles;
	
	public User(UserId id, String email, String password, Set<UserRole> roles) {
		super(id);
		this.email= email;
		this.password= password;
		this.roles= roles;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}
	
	
}

