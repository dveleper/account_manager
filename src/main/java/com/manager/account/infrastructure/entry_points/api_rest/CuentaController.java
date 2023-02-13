package com.manager.account.infrastructure.entry_points.api_rest;

import com.manager.account.domain.model.Cuenta;
import com.manager.account.domain.usercase.CuentaUseCase;
import jakarta.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final Log LOGGER = LogFactory.getLog(CuentaController.class);

    @Autowired
    private CuentaUseCase cuentaUseCase;

    @PostMapping("/save")
    public ResponseEntity<Cuenta> save(@RequestBody @Valid Cuenta cuenta) {
        LOGGER.debug(String.format("creando cuenta %s", cuenta.getTipoCuenta()));
        return new ResponseEntity<>(cuentaUseCase.crear(cuenta), HttpStatus.CREATED);
    }
}
