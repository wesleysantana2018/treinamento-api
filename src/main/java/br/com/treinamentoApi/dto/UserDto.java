package br.com.treinamentoApi.dto;

import br.com.treinamentoApi.modelo.User;

public class UserDto {
	
	private Long id;
	private String email;
	private String name;
	private String password;
	private String role;
	
	

	public UserDto(User user) {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	

}
