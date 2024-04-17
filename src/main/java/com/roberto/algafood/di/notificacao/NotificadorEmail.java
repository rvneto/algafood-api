package com.roberto.algafood.di.notificacao;

import com.roberto.algafood.di.modelo.Cliente;
import lombok.Setter;

public class NotificadorEmail implements Notificador {

    @Setter
    private boolean caixaAlta;
    private String hostServidorSmpt;

    public NotificadorEmail(String hostServidorSmpt) {
        this.hostServidorSmpt = hostServidorSmpt;
    }

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        if (caixaAlta) {
            mensagem = mensagem.toUpperCase();
        }

        System.out.printf("Notificando %s através do e-mail %s: usando SMTP %s: %s\n", cliente.getNome(), cliente.getEmail(), hostServidorSmpt, mensagem);
    }

}
