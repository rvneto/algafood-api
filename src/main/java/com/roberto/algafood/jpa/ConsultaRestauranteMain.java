package com.roberto.algafood.jpa;

import com.roberto.algafood.AlgafoodApiApplication;
import com.roberto.algafood.domain.model.Restaurante;
import com.roberto.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
        List<Restaurante> restaurantes = restauranteRepository.listar();
        for (Restaurante restaurante : restaurantes) {
            System.out.println(restaurante.getNome() + " - " + restaurante.getTaxaFrete());
        }

    }

}
