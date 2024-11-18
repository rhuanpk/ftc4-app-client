package org.example.client.core.applications.cliente.usecases;


import org.example.client.core.applications.cliente.repositories.ClienteRepositoryInterface;
import org.example.client.core.applications.exception.EntityNotFoundException;
import org.example.client.core.domain.cliente.Cliente;

public class GetClienteByCpf {

    private final ClienteRepositoryInterface clienteRepository;

    public GetClienteByCpf(ClienteRepositoryInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente execute(String cpf) {
        Cliente cliente = this.clienteRepository.getClienteByCpf(cpf);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        return cliente;
    }

}
