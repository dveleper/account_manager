package com.manager.account.infrastructure.driven_adapters.persistence.jpa.adapter;

import com.manager.account.domain.model.EstadoCuenta;
import com.manager.account.domain.model.EstadoCuentaInput;
import com.manager.account.domain.model.repository.EstadoCuentaRepository;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.MovimientoData;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.mapper.EstadoCuentaMapper;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.repository.MovimientoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstadoCuentaRepositoryAdapter implements EstadoCuentaRepository {

    @Autowired
    private MovimientoDataRepository movimientoDataRepository;

    @Autowired
    private EstadoCuentaMapper estadoCuentaMapper;

    @Override
    public List<EstadoCuenta> obtenerReporte(EstadoCuentaInput input) {
        List<MovimientoData> movimientos =
                movimientoDataRepository.findAllByCuentaClienteIdentificacionAndFechaBetweenOrderByCuentaNumeroAsc(
                         input.getIdentificacion(),
                         input.getFechaInicial(),
                         input.getFechaFinal());

        return estadoCuentaMapper.toEstadoCuentas(movimientos);
    }
}
