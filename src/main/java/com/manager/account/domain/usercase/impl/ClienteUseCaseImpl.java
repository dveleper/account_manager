package com.manager.account.domain.usercase.impl;

import com.manager.account.domain.model.Cliente;
import com.manager.account.domain.model.repository.ClienteRepository;
import com.manager.account.domain.usercase.ClienteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepository.crear(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.listarTodos();
    }

    @Override
    public Cliente listarPorIdentificacion(String identificacion) {
        return clienteRepository.listarPorIdentificacion(identificacion);
    }

    @Override
    public Cliente editar(Cliente cliente) {
        return clienteRepository.editar(cliente);
    }

    @Override
    public boolean eliminar(String identificacion) {
        return clienteRepository.eliminar(identificacion);
    }
}
