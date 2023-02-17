package com.manager.account.domain.usercase.impl;

import com.manager.account.domain.model.EstadoCuenta;
import com.manager.account.domain.model.EstadoCuentaInput;
import com.manager.account.domain.model.repository.EstadoCuentaRepository;
import com.manager.account.domain.usercase.EstadoCuentaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EstadoCuentaUseCaseImpl implements EstadoCuentaUseCase {

    private final EstadoCuentaRepository estadoCuentaRepository;

    @Override
    @Transactional
    public List<EstadoCuenta> obtenerReporte(EstadoCuentaInput input) {
        return estadoCuentaRepository.obtenerReporte(input);
    }
}
