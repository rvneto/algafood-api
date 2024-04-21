package com.roberto.algafood.di.notificacao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("notificador.email")
public class NotificadorProperties {

    private String hostServidor;
    private Integer portaServidor = 22;
}
