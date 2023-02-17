package com.manager.account.domain.usercase.impl;

import com.manager.account.domain.model.Cuenta;
import com.manager.account.domain.model.repository.CuentaRepository;
import com.manager.account.domain.usercase.CuentaUseCase;
import com.manager.account.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@AllArgsConstructor
public class CuentaUseCaseImpl implements CuentaUseCase {

    private final CuentaRepository cuentaRepository;
    @Override
    public Cuenta crear(Cuenta cuenta) {
        return cuentaRepository.crear(cuenta);
    }

    @Override
    public List<Cuenta> listar() {
        return cuentaRepository.listarTodos();
    }

    @Override
    public Cuenta listarPorNumeroCuenta(String numeroCuenta) {
        return cuentaRepository.listar(numeroCuenta);
    }

    @Override
    public List<Cuenta> listarPorCliente(String identificacionCliente) {
        return cuentaRepository.listarPorCliente(identificacionCliente);
    }

    @Override
    public Cuenta editar(Cuenta cuenta) {
        return cuentaRepository.editar(cuenta);
    }

    @Override
    public boolean eliminar(String numeroCuenta) {
        return cuentaRepository.eliminar(numeroCuenta);
    }

    @Override
    public void actualizarSaldo(String numeroCuenta, BigInteger nuevoSaldo) {
        cuentaRepository.actualizarSaldo(numeroCuenta, nuevoSaldo);
    }

    @Override
    public BigInteger realizarDebito(BigInteger saldoActual, BigInteger monto) {
        BigInteger nuevoSaldo = saldoActual.subtract(monto);
        if (nuevoSaldo.compareTo(BigInteger.ZERO) < 0 ) {
            throw new ResourceNotFoundException("Saldo no disponible");
        }
        return nuevoSaldo;
    }

    @Override
    public BigInteger realizarCredito(BigInteger saldoActual, BigInteger monto) {
        return saldoActual.add(monto);
    }
}
