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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetClienteByCpfTest {


    private GetClienteByCpf getClienteByCpf;

    @Mock
    private ClienteRepositoryInterface clienteRepositoryInterface;

    Cliente cliente;



    @Test
    void whenExecuteGetClientByIdThenReturnClient() {

        String cpf = "12345678901";

        Mockito.when(clienteRepositoryInterface.getClienteByCpf(cpf)).thenReturn(cliente);

        Cliente result = getClienteByCpf.execute(cpf);

        assertEquals(cpf, result.getCpf());
        assertEquals("Cliente 1", result.getNome());

    }


    @Test
    void whenExecuteGetClientThenReturnNotFound() {

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            getClienteByCpf.execute(null);
        });
    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getClienteByCpf = new GetClienteByCpf(clienteRepositoryInterface);

        cliente = new Cliente();
        cliente.setId("838b1e25-a271-4816-a16b-a585470d84ed");
        cliente.setNome("Cliente 1");
        cliente.setCpf("12345678901");
        cliente.setEmail("teste@teste.com");

    }

}