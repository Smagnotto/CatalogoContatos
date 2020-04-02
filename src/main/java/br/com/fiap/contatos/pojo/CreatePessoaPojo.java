package br.com.fiap.contatos.pojo;

import java.util.Set;

public class CreatePessoaPojo extends PessoaDTO {
    private Set<CreateTelefonePojo> telefones ;
    public Set<CreateTelefonePojo> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<CreateTelefonePojo> telefones) {
        this.telefones = telefones;
    }
}