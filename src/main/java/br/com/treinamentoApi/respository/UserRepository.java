package br.com.treinamentoApi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinamentoApi.modelo.User;

public interface UserRepository  extends JpaRepository<User, Long> {

}
