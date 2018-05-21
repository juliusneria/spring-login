package com.sample.login.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@EnableAutoConfiguration
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = User.class, cascade=CascadeType.ALL)
	@Column(unique = true, nullable = false)
	@JoinTable(name = "role_users",
			joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	@JsonManagedReference
	private List<User> users;

	private String name;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> privileges;

	public Role() {
		super();
	}

	public Role(final String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<String> privileges) {
		this.privileges = privileges;
	}
}