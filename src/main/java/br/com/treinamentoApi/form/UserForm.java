package br.com.treinamentoApi.form;

import java.util.Optional;

import br.com.treinamentoApi.modelo.User;
import br.com.treinamentoApi.respository.UserRepository;

public class UserForm {
	
	
	private String password;
	private String name;
	private String email;
	private String role;
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public User atulizar(Long id, UserRepository userRepository) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			user.get().setEmail(this.email);
			user.get().setName(this.name);
			user.get().setPassword(this.password);
			user.get().setRole(this.role);
			return user.get();
		}
		
		return null;
	}

}
