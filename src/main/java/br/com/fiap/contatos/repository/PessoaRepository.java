package br.com.fiap.contatos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.contatos.domain.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {

}