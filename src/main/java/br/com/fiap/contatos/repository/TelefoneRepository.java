package br.com.fiap.contatos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.contatos.domain.Telefone;

public interface TelefoneRepository extends CrudRepository <Telefone, Integer>{

}