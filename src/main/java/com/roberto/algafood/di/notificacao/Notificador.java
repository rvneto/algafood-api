package com.roberto.algafood.di.notificacao;

import com.roberto.algafood.di.modelo.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
