package br.com.fiap.contatos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.contatos.pojo.CreateTelefonePojo;

@Entity
@Table(name = "telefone")
public class Telefone {
    public Telefone() { }

    public Telefone(Integer id, CreateTelefonePojo telefone, Pessoa pessoa) {
        this.id = id;
        this.telefone = telefone.getTelefone();
        this.pessoa = pessoa;
    }

    public Telefone(CreateTelefonePojo telefone, Pessoa pessoa) {
        this.telefone = telefone.getTelefone();
        this.pessoa = pessoa;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "telefone", length = 9, nullable = false)
    @Length(min = 8, max = 9)
    private String telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPESSOA")
    private Pessoa pessoa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}