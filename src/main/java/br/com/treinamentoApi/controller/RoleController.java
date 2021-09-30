package br.com.treinamentoApi.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.treinamentoApi.dto.RoleDto;
import br.com.treinamentoApi.form.RoleForm;
import br.com.treinamentoApi.modelo.Role;
import br.com.treinamentoApi.respository.RoleRepository;


@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping
	public List<Role> all(){
		return roleRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Role> detail(@PathVariable Role id) {
		return new ResponseEntity<Role>(id,HttpStatus.OK);
	}
	
	@PostMapping
	public Role newRole(@RequestBody Role newRole) {
		return roleRepository.save(newRole);
	}
	
	@PutMapping(value="/{id}")
	@Transactional
	public ResponseEntity<RoleDto> replaceRole(@PathVariable Long id, @RequestBody RoleForm form){
		Role role = form.atualizar(id, roleRepository);
		if(Objects.nonNull(role)) {
			return ResponseEntity.ok(new RoleDto(role));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Role> remove(@PathVariable Long id){
		Optional<Role> optional = roleRepository.findById(id);
		if(optional.isPresent()) {
			roleRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
