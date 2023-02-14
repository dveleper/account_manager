package com.manager.account.domain.usercase;

import com.manager.account.domain.model.Cuenta;

import java.util.List;

public interface CuentaUseCase {
    Cuenta crear(Cuenta cuenta);
    List<Cuenta> listar();
    Cuenta listarPorNumeroCuenta(String numeroCuenta);
    List<Cuenta> listarPorCliente(String identificacionCliente);
    Cuenta editar(Cuenta cuenta);
    boolean eliminar(String numeroCuenta);
}
