package org.example.client.application.controllers.cliente.create;


import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.client.adapters.controllers.ClienteController;
import org.example.client.application.controllers.cliente.create.requests.ClienteCreateRequest;
import org.example.client.core.applications.cliente.repositories.ClienteRepositoryInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class CreateClienteController {

    private final ClienteRepositoryInterface clienteRepositoryInterface;

    @PostMapping
    @Operation(tags = "Clientes")
    public ResponseEntity<Object> create(@RequestBody ClienteCreateRequest request) {
        ClienteController clienteController = new ClienteController(this.clienteRepositoryInterface);
        return new ResponseEntity<>(clienteController.salvar(request.nome(), request.cpf(), request.email()), HttpStatus.OK);
    }

}
