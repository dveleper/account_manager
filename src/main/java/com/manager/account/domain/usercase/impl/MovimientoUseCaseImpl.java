package com.manager.account.domain.usercase.impl;

import com.manager.account.domain.model.Cuenta;
import com.manager.account.domain.model.Movimiento;
import com.manager.account.domain.model.repository.CuentaRepository;
import com.manager.account.domain.model.repository.MovimientoRepository;
import com.manager.account.domain.usercase.MovimientoUseCase;
import com.manager.account.exception.ResourceNotFoundException;
import com.manager.account.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class MovimientoUseCaseImpl implements MovimientoUseCase {
    private final MovimientoRepository movimientoRepository;
    private final CuentaRepository cuentaRepository;

    @Override
    public Movimiento crear(Movimiento movimiento) {
        movimiento.setFecha(new Date());
        afectarSaldo(movimiento);
        Movimiento transaccion = movimientoRepository.crear(movimiento);
        transaccion.getCuenta().setNumeroCuenta(movimiento.getCuenta().getNumeroCuenta());
        cuentaRepository.actualizarSaldo(movimiento.getCuenta().getNumeroCuenta(), movimiento.getSaldo());
        return transaccion;
    }


    private void afectarSaldo(Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.listar(movimiento.getCuenta().getNumeroCuenta());
        BigInteger nuevoSaldo;
        switch (movimiento.getTipoMovimiento()) {
            case Utils.DEBITO -> {
                if (cuenta.getSaldo().intValue() == 0) {
                    throw new ResourceNotFoundException("Saldo no disponible");
                }
                nuevoSaldo = cuenta.getSaldo().min(movimiento.getValor());
            }
            case Utils.CREDITO -> nuevoSaldo = cuenta.getSaldo().add(movimiento.getValor());
            default -> throw new ResourceNotFoundException(String.format("tipo de movimiento: %s no disponible", movimiento.getTipoMovimiento()));
        }
        cuenta.setSaldo(nuevoSaldo);
        movimiento.setCuenta(cuenta);
        movimiento.setSaldo(nuevoSaldo);
    }



    @Override
    public List<Movimiento> listar() {
        return movimientoRepository.listar();
    }

    @Override
    public Movimiento listarPorId(Integer idMovimiento) {
        return movimientoRepository.listarPorId(idMovimiento);
    }


    @Override
    public boolean eliminar(Integer idMovimiento) {
        return movimientoRepository.eliminar(idMovimiento);
    }

    @Override
    public List<Movimiento> listarPorCuenta(String cuenta) {
        return movimientoRepository.consultaPoCuenta(cuenta);
    }
}
