package com.manager.account.domain.usercase.impl;

import com.manager.account.domain.model.Cliente;
import com.manager.account.domain.model.repository.ClienteRepository;
import com.manager.account.domain.usercase.ClienteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente crear(Cliente cliente) {
        return clienteRepository.crear(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listar() {
        return clienteRepository.listarTodos();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente listarPorIdentificacion(String identificacion) {
        return clienteRepository.listarPorIdentificacion(identificacion);
    }

    @Override
    @Transactional
    public Cliente editar(Cliente cliente) {
        return clienteRepository.editar(cliente);
    }

    @Override
    @Transactional
    public boolean eliminar(String identificacion) {
        return clienteRepository.eliminar(identificacion);
    }
}
