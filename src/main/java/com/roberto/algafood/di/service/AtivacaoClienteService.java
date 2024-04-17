package com.roberto.algafood.di.service;

import com.roberto.algafood.di.modelo.Cliente;
import com.roberto.algafood.di.notificacao.NivelUrgencia;
import com.roberto.algafood.di.notificacao.Notificador;
import com.roberto.algafood.di.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired
    @TipoDoNotificador(NivelUrgencia.URGENTE)
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
