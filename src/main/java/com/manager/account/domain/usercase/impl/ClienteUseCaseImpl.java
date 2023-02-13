package com.manager.account.domain.usercase.impl;

import com.manager.account.domain.model.Cliente;
import com.manager.account.domain.model.repository.ClienteRepository;
import com.manager.account.domain.usercase.ClienteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepository.crear(cliente);
    }

    @Override
    public List<Cliente> listar(Cliente cliente) {
        return clienteRepository.listar(cliente);
    }

    @Override
    public Cliente editar(Cliente cliente) {
        return clienteRepository.editar(cliente);
    }

    @Override
    public void eliminar(String clienteId) {
        clienteRepository.eliminar(clienteId);
    }
}
