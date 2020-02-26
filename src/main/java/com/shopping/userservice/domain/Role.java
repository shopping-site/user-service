package com.shopping.userservice.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

	@Id
	private String roleId = UUID.randomUUID().toString();

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "role_policy", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "policy_id")})
	public Set<Policy> policies = new HashSet<>();

	@Basic(optional = false)
	@Column(name = "rolename")
	@JsonDeserialize(using = EnumDeserializer.class)
	@Enumerated(EnumType.STRING)
	private RoleNames roleName;

	public Role(String roleId) {
		this.roleId = roleId;
	}


}
