package org.example.client.application.driven.entities.cliente;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Document(collection = "TB_CLIENTE")
public class ClienteEntity {

    @Id
    private UUID id;

    private String nome;

    private String cpf;

    private String email;

    @CreatedDate
    private Instant dataCriacao;

}