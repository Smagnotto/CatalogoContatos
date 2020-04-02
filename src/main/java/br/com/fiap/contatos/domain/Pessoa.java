package br.com.fiap.contatos.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.fiap.contatos.pojo.CreatePessoaPojo;

@Table(name = "pessoa")
@Entity
public class Pessoa {
    public Pessoa() { } 

    public Pessoa(Integer id, CreatePessoaPojo pessoa) {
        this.id = id;
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();

        this.telefones = pessoa.getTelefones().stream()
                            .map(telefone -> new Telefone(telefone, this))
                            .collect(Collectors.toSet());
    }

    public Pessoa(CreatePessoaPojo pessoa) {
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        
        this.telefones = pessoa.getTelefones().stream()
                            .map(telefone -> new Telefone(telefone, this))
                            .collect(Collectors.toSet());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nome", nullable = false, length = 55)
    private String nome;

    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa")
    private Set<Telefone> telefones = new HashSet<>();

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

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }
}