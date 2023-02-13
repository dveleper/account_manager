package com.manager.account.infrastructure.driven_adapters.persistence.jpa.adapter;

import com.manager.account.domain.model.Cuenta;
import com.manager.account.domain.model.repository.CuentaRepository;
import com.manager.account.exception.ResourceNotFoundException;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.CuentaData;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.mapper.CuentaMapper;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.repository.ClienteDataRepository;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.repository.CuentaDataRepository;
import com.manager.account.util.TipoCuenta;
import com.manager.account.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CuentaDataRepositoryAdapter implements CuentaRepository {

    @Autowired
    private CuentaMapper cuentaMapper;

    @Autowired
    private CuentaDataRepository cuentaDataRepository;

    @Autowired
    private ClienteDataRepository clienteDataRepository;

    @Override
    public Cuenta crear(Cuenta cuenta) {
        // valida identificacion de cliente
        clienteDataRepository.findByIdentificacion(cuenta.getCliente().getIdentificacion())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se puede crear cuenta, persona con documento :" + cuenta.getCliente().getIdentificacion() + " No es cliente!"));

        Utils.validarTipoCuenta(cuenta.getTipoCuenta());

        CuentaData data = cuentaMapper.toCuentaData(cuenta);

        return cuentaMapper.toCuenta(cuentaDataRepository.save(data));
    }

    @Override
    public List<Cuenta> listarTodos() {
        return cuentaMapper.toCuentas((List<CuentaData>) cuentaDataRepository.findAll());
    }

    @Override
    public Cuenta listar(String numeroCuenta) {
        return cuentaDataRepository.findById(numeroCuenta)
                .map(cuentaData -> cuentaMapper.toCuenta(cuentaData))
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta :" + numeroCuenta + " Not Found!"));
    }

    @Override
    public List<Cuenta> listarPorCliente(String identificacionCliente) {
        return null;
    }


    @Override
    public Cuenta editar(Cuenta cuenta) {
        CuentaData data = cuentaMapper.toCuentaData(cuenta);
        return cuentaMapper.toCuenta(cuentaDataRepository.save(data));
    }

    @Override
    public boolean eliminar(String numeroCuenta) {
        return cuentaDataRepository.findById(numeroCuenta)
                .map(cuentaData -> {
                    cuentaDataRepository.delete(cuentaData);
                    return true;
                }).orElse(false);
    }
}
