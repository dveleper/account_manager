package com.manager.account.infrastructure.driven_adapters.persistence.jpa.adapter;

import com.manager.account.domain.model.Movimiento;
import com.manager.account.domain.model.repository.MovimientoRepository;
import com.manager.account.exception.ResourceNotFoundException;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.MovimientoData;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.mapper.MovimientoMapper;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.repository.MovimientoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovimientoDataRepositoryAdapter implements MovimientoRepository {

    @Autowired
    private MovimientoMapper movimientoMapper;

    @Autowired
    private MovimientoDataRepository movimientoDataRepository;

    @Override
    public Movimiento crear(Movimiento movimiento) {
        MovimientoData data = movimientoMapper.toMovimientoData(movimiento);
        data.getCuenta().setCuentaId(movimiento.getCuenta().getNumeroCuenta());
        return movimientoMapper.toMovimiento(movimientoDataRepository.save(data));
    }

    @Override
    public List<Movimiento> listar() {
        List<MovimientoData> movimientos = (List<MovimientoData>) movimientoDataRepository.findAll();
        if (movimientos.size() == 0) throw new ResourceNotFoundException("No existen registros de Movimientos!");
        return movimientoMapper.toMovimientos(movimientos);
    }

    @Override
    public Movimiento listarPorId(Integer idMovimiento) {
        MovimientoData data = movimientoDataRepository.findById(idMovimiento)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Movimiento con id :" + idMovimiento + " No existe!"));
        return movimientoMapper.toMovimiento(data);
    }

    @Override
    public Movimiento editar(Movimiento movimiento) {
        MovimientoData data = movimientoMapper.toMovimientoData(movimiento);
        return movimientoMapper.toMovimiento(movimientoDataRepository.save(data));
    }

    @Override
    public boolean eliminar(Integer idMovimiento) {
        return movimientoDataRepository.findById(idMovimiento)
                .map(movimientoData -> {
                    movimientoDataRepository.delete(movimientoData);
                    return true;
                }).orElse(false);
    }
}
