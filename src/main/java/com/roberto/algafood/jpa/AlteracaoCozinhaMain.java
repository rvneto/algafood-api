package com.roberto.algafood.jpa;

import com.roberto.algafood.AlgafoodApiApplication;
import com.roberto.algafood.domain.model.Cozinha;
import com.roberto.algafood.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoCozinhaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class).web(WebApplicationType.NONE).run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
        Cozinha cozinha = new Cozinha();
        cozinha.setId(7L);
        cozinha.setNome("Argentina");

        cozinha = cozinhaRepository.salvar(cozinha);

        System.out.printf("%d - %s\n", cozinha.getId(), cozinha.getNome());

    }

}
