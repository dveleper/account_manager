package com.manager.account.domain.usercase;

import com.manager.account.domain.model.Cliente;

import java.util.List;

public interface ClienteUseCase {
    Cliente crear(Cliente cliente);
    List<Cliente> listar();
    Cliente listarPorIdentificacion(String identificacion);
    Cliente editar(Cliente cliente);
    boolean eliminar(String identificacion);
}
