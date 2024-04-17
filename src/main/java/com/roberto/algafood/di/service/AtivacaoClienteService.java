package com.roberto.algafood.di.service;

import com.roberto.algafood.di.modelo.Cliente;
import com.roberto.algafood.di.notificacao.NotificadorEmail;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AtivacaoClienteService {

    private NotificadorEmail notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
