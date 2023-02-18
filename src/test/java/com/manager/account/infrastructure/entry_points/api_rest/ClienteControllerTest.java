package com.manager.account.infrastructure.entry_points.api_rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manager.account.domain.model.Cliente;
import com.manager.account.domain.usercase.ClienteUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteUseCase clienteUseCase;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void save() {
        when(clienteUseCase.crear(any(Cliente.class))).thenReturn(new Cliente());

    }

    @Test
    void getByIdentification() throws Exception {

        Cliente cliente = new Cliente();
        cliente.setNombre("felix the cat");
        cliente.setIdentificacion("123");
        cliente.setEstado("true");

        when(clienteUseCase.listarPorIdentificacion(anyString())).thenReturn(cliente);
        mockMvc.perform(get("/clientes/find/123").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("felix the cat"))
                .andExpect(jsonPath("$.estado").value("true"));
        verify(clienteUseCase).listarPorIdentificacion("123");
    }

    @Test
    void getAll() throws Exception {
        Cliente clientOne = new Cliente();
        clientOne.setNombre("felix the cat");
        clientOne.setIdentificacion("123");
        clientOne.setEstado("true");

        Cliente clientTwo = new Cliente();
        clientTwo.setNombre("max the dog");
        clientTwo.setIdentificacion("123");
        clientTwo.setEstado("false");

        List clients = Arrays.asList(clientOne, clientTwo);

        System.out.println(objectMapper.writeValueAsString(clients));

        when(clienteUseCase.listar()).thenReturn(clients);
        mockMvc.perform(get("/clientes/find").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("[0].nombre").value("felix the cat"));

        verify(clienteUseCase).listar();
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}