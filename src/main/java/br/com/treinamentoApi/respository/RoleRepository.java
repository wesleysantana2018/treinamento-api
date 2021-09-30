package br.com.treinamentoApi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinamentoApi.modelo.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{

}
