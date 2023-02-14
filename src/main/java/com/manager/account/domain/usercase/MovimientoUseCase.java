package com.manager.account.domain.usercase;

import com.manager.account.domain.model.Movimiento;

import java.util.List;

public interface MovimientoUseCase {
    Movimiento crear(Movimiento movimiento);
    List<Movimiento> listar();
    Movimiento listarPorId(Integer idMovimiento);
    Movimiento editar(Movimiento movimiento);
    boolean eliminar(Integer idMovimiento);

}
