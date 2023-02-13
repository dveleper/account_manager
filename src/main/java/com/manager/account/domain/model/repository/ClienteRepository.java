package com.manager.account.domain.model.repository;

import com.manager.account.domain.model.Cliente;

import java.util.List;

public interface ClienteRepository {
    Cliente crear(Cliente cliente);
    List<Cliente> listarTodos();
    Cliente listarPorIdentificacion(String identificacion);
    Cliente editar(Cliente cliente);
    boolean eliminar(String clienteId);
}
