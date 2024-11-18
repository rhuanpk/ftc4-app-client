package org.example.client.adapters.gateways;


import lombok.AllArgsConstructor;
import org.example.client.application.driven.entities.cliente.ClienteEntity;
import org.example.client.application.driven.repositories.cliente.ClienteRepository;
import org.example.client.core.applications.cliente.repositories.ClienteRepositoryInterface;
import org.example.client.core.domain.cliente.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ClienteGateway implements ClienteRepositoryInterface {

    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    @Override
    public Cliente getClienteById(String id) {
        ClienteEntity entity = modelMapper.map(clienteRepository.findById(id), ClienteEntity.class);
        if (entity == null) {
            return null;
        }
        return modelMapper.map(entity, Cliente.class);
    }

    @Override
    public Cliente getClienteByCpf(String cpf) {
        ClienteEntity entity = modelMapper.map(clienteRepository.findByCpf(cpf), ClienteEntity.class);
        return modelMapper.map(entity, Cliente.class);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        ClienteEntity entity = modelMapper.map(cliente, ClienteEntity.class);
        ClienteEntity save = clienteRepository.save(entity);
        return modelMapper.map(save, Cliente.class);
    }
}
