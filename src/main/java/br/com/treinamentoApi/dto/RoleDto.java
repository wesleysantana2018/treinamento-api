package br.com.treinamentoApi.dto;

import br.com.treinamentoApi.modelo.Role;

public class RoleDto {
	
	private Long id;
	private String nameRole;
	
	
	public RoleDto(Role role) {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNameRole() {
		return nameRole;
	}


	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	
	

}
