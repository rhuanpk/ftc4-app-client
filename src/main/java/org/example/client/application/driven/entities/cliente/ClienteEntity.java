package org.example.client.application.driven.entities.cliente;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "TB_CLIENTE")
public class ClienteEntity {

    @Id
    private String id;

    private String nome;

    private String cpf;

    private String email;

    @CreatedDate
    private Instant dataCriacao;

}