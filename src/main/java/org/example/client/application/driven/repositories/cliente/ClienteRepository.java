package org.example.client.application.driven.repositories.cliente;

import org.example.client.application.driven.entities.cliente.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {

    ClienteEntity findByCpf(String cpf);

    Boolean existsByCpf(String cpf);

}