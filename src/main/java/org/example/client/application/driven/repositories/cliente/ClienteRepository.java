package org.example.client.application.driven.repositories.cliente;

import org.example.client.application.driven.entities.cliente.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ClienteRepository extends MongoRepository<ClienteEntity, UUID> {

    ClienteEntity findByCpf(String cpf);

    Boolean existsByCpf(String cpf);

}