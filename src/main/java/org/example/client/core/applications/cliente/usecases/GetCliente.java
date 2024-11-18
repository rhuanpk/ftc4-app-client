package org.example.client.core.applications.cliente.usecases;



import org.example.client.core.applications.cliente.repositories.ClienteRepositoryInterface;
import org.example.client.core.applications.exception.EntityNotFoundException;
import org.example.client.core.domain.cliente.Cliente;

import java.util.UUID;

public class GetCliente {

    private final ClienteRepositoryInterface clienteRepository;

    public GetCliente(ClienteRepositoryInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente execute(String id) {
        Cliente cliente = this.clienteRepository.getClienteById(id);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        return cliente;
    }

}
