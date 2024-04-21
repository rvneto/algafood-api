package com.roberto.algafood.listener;

import com.roberto.algafood.di.notificacao.NivelUrgencia;
import com.roberto.algafood.di.notificacao.Notificador;
import com.roberto.algafood.di.notificacao.TipoDoNotificador;
import com.roberto.algafood.di.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @Autowired
    @TipoDoNotificador(NivelUrgencia.NORMAL)
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
    }

}
