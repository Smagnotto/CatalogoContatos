package br.com.fiap.contatos.pojo;

import br.com.fiap.contatos.domain.Telefone;

public class TelefonePojo {

    public TelefonePojo(Telefone telefone)  {
        this.telefone = telefone.getTelefone();
    }

    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}