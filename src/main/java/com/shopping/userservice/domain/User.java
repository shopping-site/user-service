package com.shopping.userservice.domain;

import com.shopping.userservice.controller.dto.CreateUserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


/**
 * User details
 * User is either internal user or student
 */
@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

	@Id
	@Column(name = "user_id")
	private String userId = UUID.randomUUID().toString();

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles = new HashSet<>();

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "mobile", unique = true)
	private String mobile;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "password")
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_status")
	private UserState userStatus = UserState.CHANGE_PASSWORD;

	@Column(name = "email_verified")
	private boolean emailVerified;

	@Column(name = "mobile_no_verified")
	private boolean mobileNumberVerified;

	@Column(name = "active")
	private boolean active = true;

	@Column(name = "customer")
	private boolean customer;

	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "user_profile_id", referencedColumnName = "user_profile_id")
	private UserProfile userProfile;

	public User(CreateUserDTO createUserDTO) {
		this.email = createUserDTO.getEmail();
		this.mobile = createUserDTO.getMobile();
		this.password = createUserDTO.getPassword();
	}

}
