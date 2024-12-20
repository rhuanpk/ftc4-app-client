package org.example.client.application.controllers.cliente.search;


import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.client.adapters.controllers.ClienteController;
import org.example.client.core.applications.cliente.repositories.ClienteRepositoryInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class SearchClienteController {

    private final ClienteRepositoryInterface clienteRepositoryInterface;

    @GetMapping("/search")
    @Operation(tags = "Clientes")
    public ResponseEntity<Object> searchCliente(@RequestParam("cpf") String cpf) {
        ClienteController clienteController = new ClienteController(this.clienteRepositoryInterface);
        return new ResponseEntity<>(clienteController.getByCpf(cpf), HttpStatus.OK);
    }

}
