package com.manager.account.infrastructure.entry_points.api_rest;

import com.manager.account.domain.model.Cliente;
import com.manager.account.domain.usercase.ClienteUseCase;
import jakarta.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final Log LOGGER = LogFactory.getLog(ClienteController.class);

    @Autowired
    private ClienteUseCase clienteUseCase;

    @PostMapping("/save")
    public ResponseEntity<Cliente> save(@RequestBody @Valid Cliente cliente) {
        LOGGER.debug(String.format("Creando cliente con data %s", cliente), null);
        return new ResponseEntity<>(clienteUseCase.crear(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/find/{identificacion}")
    public Cliente getByIdentification(@PathVariable String identificacion) {
        return clienteUseCase.listarPorIdentificacion(identificacion);
    }

    @GetMapping("/find")
    public List<Cliente> getAll() {
        return clienteUseCase.listar();
    }

    @DeleteMapping(value = "/delete/{identificacion}")
    public ResponseEntity<Cliente> delete (@PathVariable String identificacion) {
        if(clienteUseCase.eliminar(identificacion)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{identificacion}")
    public ResponseEntity<Cliente> update (@RequestBody @Valid Cliente cliente) {
        return new ResponseEntity<>(clienteUseCase.editar(cliente), HttpStatus.OK);
    }

}
