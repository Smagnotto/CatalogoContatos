package br.com.fiap.contatos.pojo;

import java.util.Set;

public class CreatePessoaPojo {
    private String nome;
    private String cpf;
    private Set<CreateTelefonePojo> telefones;

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

    public Set<CreateTelefonePojo> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<CreateTelefonePojo> telefones) {
        this.telefones = telefones;
    }
}