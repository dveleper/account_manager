package com.manager.account.domain.usercase;

import com.manager.account.domain.model.Cliente;

import java.util.List;

public interface ClienteUseCase {
    Cliente crear(Cliente cliente);
    List<Cliente> listar(Cliente cliente);
    Cliente editar(Cliente cliente);
    void eliminar(String clienteId);
}
