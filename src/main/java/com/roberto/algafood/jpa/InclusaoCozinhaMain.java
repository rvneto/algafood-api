package com.roberto.algafood.jpa;

import com.roberto.algafood.AlgafoodApiApplication;
import com.roberto.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoCozinhaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
        Cozinha cozinhaBrasileira = new Cozinha();
        cozinhaBrasileira.setNome("Brasileira");

        Cozinha cozinhaJaponesa = new Cozinha();
        cozinhaJaponesa.setNome("Japonesa");

        cozinhaBrasileira = cadastroCozinha.adicionar(cozinhaBrasileira);
        cozinhaJaponesa = cadastroCozinha.adicionar(cozinhaJaponesa);

        System.out.printf("%d - %s\n", cozinhaBrasileira.getId(), cozinhaBrasileira.getNome());
        System.out.printf("%d - %s\n", cozinhaJaponesa.getId(), cozinhaJaponesa.getNome());

    }

}
