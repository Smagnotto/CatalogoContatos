package br.com.fiap.contatos.pojo;

import java.util.Set;
import java.util.stream.Collectors;

import br.com.fiap.contatos.domain.Pessoa;

public class PessoaPojo {
    public PessoaPojo(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.telefones = pessoa.getTelefones()
                                .stream()
                                .map(TelefonePojo::new)
                                .collect(Collectors.toSet());
    }

    private Integer id;
    private String nome;
    private String cpf;
    private Set<TelefonePojo> telefones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<TelefonePojo> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<TelefonePojo> telefones) {
        this.telefones = telefones;
    }
}