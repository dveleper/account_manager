package com.manager.account.domain.model.repository;

import com.manager.account.domain.model.Cuenta;

import java.util.List;

public interface CuentaRepository {
    Cuenta crear(Cuenta cuenta);
    List<Cuenta> listar(Cuenta cuenta);
    Cuenta editar(Cuenta cuenta);
    void eliminar(String numeroCuenta);
}
