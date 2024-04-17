package com.roberto.algafood.config;

import com.roberto.algafood.di.notificacao.NotificadorEmail;
import com.roberto.algafood.di.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public AtivacaoClienteService ativacaoClienteService(NotificadorEmail notificador) {
        return new AtivacaoClienteService(notificador);
    }

}
