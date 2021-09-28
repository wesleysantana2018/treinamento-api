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

import br.com.treinamentoApi.dto.UserDto;
import br.com.treinamentoApi.form.UserForm;
import br.com.treinamentoApi.modelo.User;
import br.com.treinamentoApi.respository.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;	

	@GetMapping()
	public List<User> all() {
		return  userRepository.findAll();
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<User> detail(@PathVariable User id) {
		return new ResponseEntity<User>(id,HttpStatus.OK);
	}
	

	@PostMapping()
	public User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
		
	}
	
	@PutMapping(value ="/{id}")
	@Transactional
	public ResponseEntity<UserDto> replaceUser( @PathVariable Long id, @RequestBody UserForm form) {
		User user = form.atulizar(id,userRepository);
			if(Objects.nonNull(user)) {
				return ResponseEntity.ok(new UserDto(user));
			}
			return ResponseEntity.notFound().build();
		}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id){
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
