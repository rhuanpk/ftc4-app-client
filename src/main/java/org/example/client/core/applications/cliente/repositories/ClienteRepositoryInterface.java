package org.example.client.core.applications.cliente.repositories;


import org.example.client.core.domain.cliente.Cliente;

import java.util.UUID;

public interface ClienteRepositoryInterface {

    Cliente getClienteById(UUID id);

    Cliente getClienteByCpf(String cpf);

    Cliente saveCliente(Cliente cliente);

}
