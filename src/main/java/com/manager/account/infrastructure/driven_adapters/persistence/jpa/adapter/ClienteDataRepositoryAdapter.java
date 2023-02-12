package com.manager.account.infrastructure.driven_adapters.persistence.jpa.adapter;

import com.manager.account.domain.model.Cliente;
import com.manager.account.domain.model.repository.ClienteRepository;

import java.util.List;

public class ClienteDataRepositoryAdapter implements ClienteRepository {
    @Override
    public Cliente crear(Cliente cliente) {
        return null;
    }

    @Override
    public List<Cliente> listar(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente editar(Cliente cliente) {
        return null;
    }

    @Override
    public void eliminar(String clienteId) {

    }
}
