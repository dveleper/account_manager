package com.manager.account.infrastructure.entry_points.api_rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manager.account.domain.model.Cliente;
import com.manager.account.domain.model.Cuenta;
import com.manager.account.domain.model.Movimiento;
import com.manager.account.domain.usercase.MovimientoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovimientoController.class)
class MovimientoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovimientoUseCase movimientoUseCase;

    private Movimiento movimiento;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        buildMovimiento();
        buildMovimientos();
    }

    @Test
    void save() throws Exception {
        when(movimientoUseCase.crear(any())).thenReturn(movimiento);
        mockMvc.perform(post("/movimientos/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movimiento)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.valor").value(new BigInteger("500000")))
                .andExpect(jsonPath("$.tipoMovimiento", is("CREDITO")));
        verify(movimientoUseCase).crear(any());
    }

    @Test
    void getAll() throws Exception {
        when(movimientoUseCase.listar()).thenReturn(buildMovimientos());
        mockMvc.perform(get("/movimientos/find").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("[0].tipoMovimiento").value("DEBITO"))
                .andExpect(jsonPath("[0].valor").value(new BigInteger("500")))
                .andExpect(jsonPath("[1].tipoMovimiento").value("CREDITO"))
                .andExpect(jsonPath("[1].valor").value(new BigInteger("100000")));
        verify(movimientoUseCase).listar();
    }

    @Test
    void getByIdMovimiento() throws Exception {
        when(movimientoUseCase.listarPorId(any())).thenReturn(movimiento);
        mockMvc.perform(get("/movimientos/find/100225").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.tipoMovimiento").value("CREDITO"))
                .andExpect(jsonPath("$.valor").value(new BigInteger("500000")));
        verify(movimientoUseCase).listarPorId(100225);
    }

    @Test
    void getByIdIdentification() throws Exception {
        when(movimientoUseCase.listarPorCuenta(any())).thenReturn(buildMovimientos());
        mockMvc.perform(get("/movimientos/find/cuenta/00000024560").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].tipoMovimiento").value("DEBITO"))
                .andExpect(jsonPath("$[0].cuenta.numero").value(new BigInteger("00000024560")));
        verify(movimientoUseCase).listarPorCuenta("00000024560");
    }

    @Test
    void delete() throws Exception {
        when(movimientoUseCase.eliminar(any())).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/movimientos/delete/123")
                        .param("numero", "123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(movimientoUseCase).eliminar(123);
    }

    @Test
    void deleteException() throws Exception {
        when(movimientoUseCase.eliminar(any())).thenReturn(false);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/movimientos/delete/123")
                        .param("numero", "123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
        verify(movimientoUseCase).eliminar(123);
    }

    private void buildMovimiento() {
        movimiento = new Movimiento();
        movimiento.setIdMovimiento(100225);
        movimiento.setTipoMovimiento("CREDITO");
        movimiento.setFecha(new Date());
        movimiento.setSaldo(BigInteger.ZERO);
        movimiento.setValor(new BigInteger("500000"));
        movimiento.setCuenta(buildCuentaAhorros());
    }

    private Movimiento buildMovimientoDebito() {
        Movimiento movimiento = new Movimiento();
        movimiento.setTipoMovimiento("DEBITO");
        movimiento.setFecha(new Date());
        movimiento.setSaldo(new BigInteger("1000"));
        movimiento.setValor(new BigInteger("500"));
        movimiento.setCuenta(buildCuentaAhorros());
        return movimiento;
    }

    private Movimiento buildMovimientoCredito() {
        Movimiento movimiento = new Movimiento();
        movimiento.setTipoMovimiento("CREDITO");
        movimiento.setFecha(new Date());
        movimiento.setSaldo(BigInteger.ZERO);
        movimiento.setValor(new BigInteger("100000"));
        movimiento.setCuenta(buildCuentaAhorros());
        return movimiento;
    }

    private List<Movimiento> buildMovimientos() {
        return Arrays.asList(buildMovimientoDebito(), buildMovimientoCredito());
    }

    private Cuenta buildCuentaAhorros() {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumero("00000024560");
        cuenta.setTipoCuenta("AHORROS");
        cuenta.setSaldo(BigInteger.ZERO);
        cuenta.setEstado("true");
        cuenta.setCliente(buildCliente());
        return cuenta;
    }

    private Cliente buildCliente() {
        Cliente cliente = new Cliente();
        cliente.setContrasena("12345678");
        cliente.setGenero("masculino");
        cliente.setEdad(40);
        cliente.setDireccion("cra 3 #76-20 Jardin etapa 1");
        cliente.setNombre("felix the cat");
        cliente.setIdentificacion("123");
        cliente.setEstado("true");
        cliente.setTelefono("0000000000");
        return cliente;
    }

}
