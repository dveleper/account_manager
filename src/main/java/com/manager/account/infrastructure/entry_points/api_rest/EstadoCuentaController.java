package com.manager.account.infrastructure.entry_points.api_rest;

import com.manager.account.domain.model.EstadoCuenta;
import com.manager.account.domain.model.EstadoCuentaInput;
import com.manager.account.domain.usercase.EstadoCuentaUseCase;
import com.manager.account.util.Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/reportes")
public class EstadoCuentaController {

    @Autowired
    private EstadoCuentaUseCase estadoCuentaUseCase;
    private final Log LOGGER = LogFactory.getLog(EstadoCuentaController.class);

    @PostMapping("/{fecha_inicial}/{fecha_final}")
    public ResponseEntity<List<EstadoCuenta>> getEstadoCuenta(@PathVariable String fecha_inicial, @PathVariable String fecha_final, @RequestBody EstadoCuentaInput input) throws ParseException {
        LOGGER.debug("generando reporte ... ");
        input.setFechaInicial(Utils.getDateFormat(fecha_inicial));
        input.setFechaFinal(Utils.getDateFormat(fecha_final));
        return new ResponseEntity<>(estadoCuentaUseCase.obtenerReporte(input), HttpStatus.OK);
    }
}
