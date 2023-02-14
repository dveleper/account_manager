package com.manager.account.domain.usercase.impl;

import com.manager.account.domain.model.EstadoCuenta;
import com.manager.account.domain.model.EstadoCuentaInput;
import com.manager.account.domain.usercase.EstadoCuentaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstadoCuentaUseCaseImpl implements EstadoCuentaUseCase {

    @Override
    public List<EstadoCuenta> obtenerReporte(EstadoCuentaInput input) {
        return null;
    }
}
