package org.example.client.application.controllers.cliente.get;


import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.client.adapters.controllers.ClienteController;
import org.example.client.core.applications.cliente.repositories.ClienteRepositoryInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class GetClienteController {

    private final ClienteRepositoryInterface clienteRepositoryInterface;

    @GetMapping("/{id}")
    @Operation(tags = "Clientes")
    public ResponseEntity<Object> get(@PathVariable("id") String id) {
        ClienteController clienteController = new ClienteController(this.clienteRepositoryInterface);
        return new ResponseEntity<>(clienteController.get(id), HttpStatus.OK);
    }

}
