package org.example.client.application.controllers.cliente.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.client.application.controllers.cliente.get.GetClienteController;
import org.example.client.core.applications.cliente.repositories.ClienteRepositoryInterface;
import org.example.client.core.domain.cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SearchClienteControllerTest {


    @Mock
    private ClienteRepositoryInterface clienteRepositoryInterface;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    Cliente cliente;

    @Test
    void whenSearchClientByCpfThenReturn200() throws Exception {

        when(clienteRepositoryInterface.getClienteByCpf(cliente.getCpf())).thenReturn(cliente);

        mockMvc.perform(get("/clientes/search")
                        .param("cpf", cliente.getCpf()))
                .andExpect(status().isOk());
    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        SearchClienteController searchClienteController = new SearchClienteController(clienteRepositoryInterface);
        this.mockMvc = MockMvcBuilders.standaloneSetup(searchClienteController).build();


        cliente = new Cliente();
        cliente.setId("838b1e25-a271-4816-a16b-a585470d84ed");
        cliente.setNome("Cliente 1");
        cliente.setCpf("12345678901");
        cliente.setEmail("teste@teste.com");


    }

}