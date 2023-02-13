package com.manager.account.domain.model.repository;

import com.manager.account.domain.model.Cuenta;

import java.util.List;

public interface CuentaRepository {
    Cuenta crear(Cuenta cuenta);
    List<Cuenta> listarTodos();
    Cuenta listar(String numeroCuenta);
    List<Cuenta> listarPorCliente(String identificacionCliente);
    Cuenta editar(Cuenta cuenta);
    boolean eliminar(String numeroCuenta);
}
