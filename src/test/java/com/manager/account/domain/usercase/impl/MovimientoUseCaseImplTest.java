package com.manager.account.domain.usercase.impl;

import com.manager.account.domain.model.Cuenta;
import com.manager.account.domain.model.Movimiento;
import com.manager.account.domain.model.repository.MovimientoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

import static org.mockito.Mockito.when;

class MovimientoUseCaseImplTest {

    @Mock
    private MovimientoRepository movimientoRepository;

    private Movimiento movimiento;

    @InjectMocks
    private MovimientoUseCaseImpl movimientoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        movimiento = new Movimiento(
                01,
                new Date(),
                "CREDITO",
                BigInteger.valueOf(10000),
                BigInteger.valueOf(10000),
                new Cuenta());
    }

    @Test
    void listar() {
        when(movimientoRepository.listar()).thenReturn(Arrays.asList(movimiento));
        Assertions.assertNotNull(movimientoUseCase.listar());
    }
}
