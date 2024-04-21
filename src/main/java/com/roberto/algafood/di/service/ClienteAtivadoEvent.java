package com.roberto.algafood.di.service;

import com.roberto.algafood.di.modelo.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClienteAtivadoEvent {

    private Cliente cliente;

}
