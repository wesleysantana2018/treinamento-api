package br.com.treinamentoApi.form;

import java.util.Optional;

import br.com.treinamentoApi.modelo.Role;
import br.com.treinamentoApi.respository.RoleRepository;

public class RoleForm {
	
	private String nameRole;
	
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	
	public Role atualizar(Long id, RoleRepository roleRepository) {
		Optional<Role> role = roleRepository.findById(id);
		
		if(role.isPresent()) {
			role.get().setNameRole(nameRole);
			return role.get();
		}
		return null;
	}
	
}
