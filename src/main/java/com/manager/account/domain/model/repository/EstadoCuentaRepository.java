package com.manager.account.domain.model.repository;

import com.manager.account.domain.model.EstadoCuenta;
import com.manager.account.domain.model.EstadoCuentaInput;

import java.util.List;

public interface EstadoCuentaRepository {
    List<EstadoCuenta> obtenerReporte(EstadoCuentaInput input);
}
