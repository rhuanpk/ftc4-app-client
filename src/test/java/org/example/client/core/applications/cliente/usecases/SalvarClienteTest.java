package org.example.client.core.applications.cliente.usecases;

import org.example.client.application.driven.entities.cliente.ClienteEntity;
import org.example.client.core.applications.cliente.repositories.ClienteRepositoryInterface;
import org.example.client.core.applications.exception.EntityNotFoundException;
import org.example.client.core.domain.cliente.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalvarClienteTest {

    private SalvarCliente salvarCliente;

    @Mock
    private ClienteRepositoryInterface clienteRepositoryInterface;

    Cliente cliente;

    ClienteEntity clienteEntity;



    @Test
    void whenExecuteSaveClientThenReturnSuccess() {

        Mockito.when(clienteRepositoryInterface.saveCliente(Mockito.any(Cliente.class))).thenReturn(cliente);

        Cliente result = salvarCliente.execute(clienteEntity.getNome(), clienteEntity.getCpf(), clienteEntity.getEmail());

        assertNotNull(result.getId());
        assertEquals(clienteEntity.getNome(), result.getNome());

    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        salvarCliente = new SalvarCliente(clienteRepositoryInterface);

        cliente = new Cliente();
        cliente.setId("838b1e25-a271-4816-a16b-a585470d84ed");
        cliente.setNome("Cliente 1");
        cliente.setCpf("12345678901");
        cliente.setEmail("teste@teste.com");

        clienteEntity = new ClienteEntity();
        clienteEntity.setId("838b1e25-a271-4816-a16b-a585470d84ed");
        clienteEntity.setNome("Cliente 1");
        clienteEntity.setCpf("12345678901");
        clienteEntity.setEmail("teste@teste.com");



    }

}