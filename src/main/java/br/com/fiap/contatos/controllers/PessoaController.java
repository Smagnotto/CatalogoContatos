package br.com.fiap.contatos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.contatos.pojo.CreatePessoaPojo;
import br.com.fiap.contatos.pojo.PessoaPojo;
import br.com.fiap.contatos.service.PessoaService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @ApiResponse(code = 200, message= "Retorna uma lista de pessoas cadastrados")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PessoaPojo> getAll() {
        return service.getAll();
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna o pessoa cadastrado"),
        @ApiResponse(code = 404, message = "Id do pessoa informado não existe")
    })
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaPojo getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @ApiResponse(code = 200, message = "Retorna o pessoa criado")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaPojo create(@RequestBody @Valid CreatePessoaPojo pessoa){
        return service.create(pessoa);
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna o pessoa atualizado"),
        @ApiResponse(code = 404, message = "Id do pessoa informado não existe")
    })
    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaPojo update(@PathVariable Integer id, @RequestBody @Valid CreatePessoaPojo pessoa) {
        return service.update(id, pessoa);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}