package com.roberto.algafood.controller;

import com.roberto.algafood.di.modelo.Cliente;
import com.roberto.algafood.di.service.AtivacaoClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class MeuPrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente joao = new Cliente("João", "joao@gmail.com", "31221213323", false);
        ativacaoClienteService.ativar(joao);

        return "Hello!";
    }

}
