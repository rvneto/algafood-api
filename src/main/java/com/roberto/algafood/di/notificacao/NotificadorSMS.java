package com.roberto.algafood.di.notificacao;

import com.roberto.algafood.di.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class NotificadorSMS implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através por SMS através do telefone %s: %s\n", cliente.getNome(), cliente.getTelefone(), mensagem);
    }

}
