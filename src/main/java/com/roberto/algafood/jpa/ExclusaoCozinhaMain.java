package com.roberto.algafood.jpa;

import com.roberto.algafood.AlgafoodApiApplication;
import com.roberto.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoCozinhaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
        Cozinha cozinha = new Cozinha();
        cozinha.setId(7L);

        cadastroCozinha.remover(cozinha);

     }

}
