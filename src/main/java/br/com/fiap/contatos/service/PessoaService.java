package br.com.fiap.contatos.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.contatos.domain.Pessoa;
import br.com.fiap.contatos.pojo.CreatePessoaPojo;
import br.com.fiap.contatos.pojo.PessoaPojo;
import br.com.fiap.contatos.pojo.UpdatePessoaPojo;
import br.com.fiap.contatos.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;
    
    public List<PessoaPojo> getAll() {
        Iterable<Pessoa> allPessoas = repository.findAll();

        return StreamSupport.stream(allPessoas.spliterator(), false)
            .map(PessoaPojo::new)
            .collect(Collectors.toList());
    }

    public PessoaPojo findById(Integer id) {
        Pessoa pessoa =  getById(id);

        return new PessoaPojo(pessoa);
    }

    public PessoaPojo create(CreatePessoaPojo pessoaPojo) {
        Pessoa pessoa = new Pessoa(pessoaPojo);
        Pessoa pessoaSaved = repository.save(pessoa);
        return new PessoaPojo(pessoaSaved);
    }

    public PessoaPojo update(Integer id, UpdatePessoaPojo pessoaCreate) {
        Pessoa pessoa = getById(id);

        pessoa.setNome(pessoaCreate.getNome());
        pessoa.setCpf(pessoaCreate.getCpf());

        Pessoa pessoaUpdated = repository.save(pessoa);
        return new PessoaPojo(pessoaUpdated);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private Pessoa getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}