package org.example.client.application.controllers.cliente.get;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.client.adapters.presenters.ClientePresenter;
import org.example.client.application.controllers.cliente.create.CreateClienteController;
import org.example.client.core.applications.cliente.repositories.ClienteRepositoryInterface;
import org.example.client.core.domain.cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class GetClienteControllerTest {


    @Mock
    private ClienteRepositoryInterface clienteRepositoryInterface;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    Cliente cliente;

    @Test
    void whenGetClientByIdThenReturn200() throws Exception {

        when(clienteRepositoryInterface.getClienteById(cliente.getId())).thenReturn(cliente);

        mockMvc.perform(get("/clientes/{id}", cliente.getId()))
                .andExpect(status().isOk());

    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        GetClienteController getClienteController = new GetClienteController(clienteRepositoryInterface);
        this.mockMvc = MockMvcBuilders.standaloneSetup(getClienteController).build();


        cliente = new Cliente();
        cliente.setId("838b1e25-a271-4816-a16b-a585470d84ed");
        cliente.setNome("Cliente 1");
        cliente.setCpf("12345678901");
        cliente.setEmail("teste@teste.com");


    }

}