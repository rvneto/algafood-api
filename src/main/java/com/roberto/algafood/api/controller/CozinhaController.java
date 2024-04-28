package com.roberto.algafood.api.controller;

import com.roberto.algafood.api.model.CozinhasXmlWrapper;
import com.roberto.algafood.domain.model.Cozinha;
import com.roberto.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXmlWrapper listarXml() {
        return new CozinhasXmlWrapper(cozinhaRepository.listar());
    }

    @GetMapping(value = "/{cozinhaId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha buscar(@PathVariable("cozinhaId") Long id) {
        return cozinhaRepository.buscar(id);
    }
}
