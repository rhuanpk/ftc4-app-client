package org.example.client.core.applications.cliente.usecases;

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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetClienteTest {

    private GetCliente getCliente;

    @Mock
    private ClienteRepositoryInterface clienteRepositoryInterface;

    Cliente cliente;



    @Test
    void whenExecuteGetClientByIdThenReturnClient() {

        String id   = "838b1e25-a271-4816-a16b-a585470d84ed";

        Mockito.when(clienteRepositoryInterface.getClienteById(id)).thenReturn(cliente);

        Cliente result = getCliente.execute(id);

        assertEquals(id, result.getId());
        assertEquals("Cliente 1", result.getNome());
    }


    @Test
    void whenExecuteGetClientThenReturnNotFound() {

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            getCliente.execute(null);
        });
    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getCliente = new GetCliente(clienteRepositoryInterface);



        cliente = new Cliente();
        cliente.setId("838b1e25-a271-4816-a16b-a585470d84ed");
        cliente.setNome("Cliente 1");
        cliente.setCpf("12345678901");
        cliente.setEmail("teste@teste.com");

    }

}