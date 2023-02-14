package com.manager.account.domain.usercase;

import com.manager.account.domain.model.EstadoCuenta;
import com.manager.account.domain.model.EstadoCuentaInput;

import java.util.List;

public interface EstadoCuentaUseCase {
    List<EstadoCuenta> obtenerReporte(EstadoCuentaInput input);
}
