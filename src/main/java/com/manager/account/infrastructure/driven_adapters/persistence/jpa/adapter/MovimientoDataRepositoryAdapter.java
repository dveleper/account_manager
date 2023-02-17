package com.manager.account.infrastructure.driven_adapters.persistence.jpa.adapter;

import com.manager.account.domain.model.Movimiento;
import com.manager.account.domain.model.repository.MovimientoRepository;
import com.manager.account.exception.ResourceNotFoundException;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.MovimientoData;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.mapper.MovimientoMapper;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.repository.MovimientoDataRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
public class MovimientoDataRepositoryAdapter implements MovimientoRepository {

    @Autowired
    private MovimientoMapper movimientoMapper;

    @Autowired
    private MovimientoDataRepository movimientoDataRepository;

    @Override
    public Movimiento crear(Movimiento movimiento) {
        MovimientoData data = movimientoMapper.toMovimientoData(movimiento);
        return movimientoMapper.toMovimiento(movimientoDataRepository.save(data));
    }

    @Override
    public List<Movimiento> listar() {
        Iterable<MovimientoData> movimientos = movimientoDataRepository.findAll();
        if (!movimientos.iterator().hasNext()) throw new ResourceNotFoundException("No existen registros de Movimientos!");
        return movimientoMapper.toMovimientos(StreamSupport.stream(movimientos.spliterator(), false).toList());
    }

    @Override
    public Movimiento listarPorId(Integer idMovimiento) {
        MovimientoData data = movimientoDataRepository.findById(idMovimiento)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Movimiento con id :" + idMovimiento + " No existe!"));
        return movimientoMapper.toMovimiento(data);
    }

    @Override
    public boolean eliminar(Integer idMovimiento) {
        return movimientoDataRepository.findById(idMovimiento)
                .map(movimientoData -> {
                    movimientoDataRepository.delete(movimientoData);
                    return true;
                }).orElse(false);
    }

    @Override
    public List<Movimiento> consultaPoCuenta(String cuenta) {
        return movimientoMapper.toMovimientos(
                movimientoDataRepository.findByCuentaNumero(cuenta)
        );
    }
}
