package com.manager.account.infrastructure.driven_adapters.persistence.jpa.adapter;

import com.manager.account.domain.model.Cuenta;
import com.manager.account.domain.model.repository.CuentaRepository;

import java.util.List;

public class CuentaDataRepositoryAdapter implements CuentaRepository {
    @Override
    public Cuenta crear(Cuenta cuenta) {
        return null;
    }

    @Override
    public List<Cuenta> listar(Cuenta cuenta) {
        return null;
    }

    @Override
    public Cuenta editar(Cuenta cuenta) {
        return null;
    }

    @Override
    public void eliminar(String numeroCuenta) {

    }
}
