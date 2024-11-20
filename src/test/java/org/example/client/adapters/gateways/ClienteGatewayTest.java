package org.example.client.adapters.gateways;

import org.example.client.application.driven.entities.cliente.ClienteEntity;
import org.example.client.application.driven.repositories.cliente.ClienteRepository;
import org.example.client.core.domain.cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClienteGatewayTest {


    @Mock
    private ClienteRepository clienteRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private ClienteGateway clienteGateway;

    Cliente cliente;

    ClienteEntity clienteEntity;
    

    @Test
    void whenSaveClientThenReturnSuccess() {
        when(modelMapper.map(cliente, ClienteEntity.class)).thenReturn(clienteEntity);
        when(clienteRepository.save(any())).thenReturn(clienteEntity);
        when(modelMapper.map(clienteEntity, Cliente.class)).thenReturn(cliente);

        Cliente result = clienteGateway.saveCliente(cliente);

        verify(clienteRepository).save(clienteEntity);

        assertNotNull(result);
        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getCpf(), result.getCpf());
    }

    @Test
    void whenGetClientByIdThenReturnSuccess() {
        when(clienteRepository.findById(cliente.getId())).thenReturn(Optional.of(clienteEntity));
        when(modelMapper.map(clienteEntity, Cliente.class)).thenReturn(cliente);

        Cliente result = clienteGateway.getClienteById(cliente.getId());

        assertNotNull(result);

        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getCpf(), result.getCpf());
    }

    @Test
    void whenGetClientByIdThenReturnClient() {
        when(clienteRepository.findByCpf(clienteEntity.getCpf())).thenReturn(clienteEntity);
        when(modelMapper.map(clienteEntity, Cliente.class)).thenReturn(cliente);

        Cliente result = clienteGateway.getClienteByCpf(clienteEntity.getCpf());

        assertNotNull(result);
        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getCpf(), result.getCpf());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        clienteEntity = new ClienteEntity();
        clienteEntity.setId("f5d4b3d2-3b4c-4a3d-8f5e-2b1c4d3e4f5a");
        clienteEntity.setNome("cliente 1");
        clienteEntity.setCpf("12345678901");

        cliente = new Cliente();
        cliente.setId("f5d4b3d2-3b4c-4a3d-8f5e-2b1c4d3e4f5a");
        cliente.setNome("cliente 1");
        cliente.setCpf("12345678901");

    }

}