package com.manager.account.infrastructure.driven_adapters.persistence.jpa.adapter;

import com.manager.account.domain.model.Movimiento;
import com.manager.account.domain.model.repository.MovimientoRepository;

import java.util.List;

public class MovimientoDataRepositoryAdapter implements MovimientoRepository {
    @Override
    public Movimiento crear(Movimiento movimiento) {
        return null;
    }

    @Override
    public List<Movimiento> listar(Movimiento movimiento) {
        return null;
    }

    @Override
    public Movimiento editar(Movimiento movimiento) {
        return null;
    }

    @Override
    public void eliminar(Integer idMovimiento) {

    }
}
