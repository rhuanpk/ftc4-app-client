package org.example.client.application.controllers.cliente.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.client.adapters.presenters.ClientePresenter;
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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CreateClienteControllerTest {

    @Mock
    private ClienteRepositoryInterface clienteRepositoryInterface;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    Cliente cliente;

    @Test
    void whenCreateClientThenReturn201() throws Exception {

        Map<String, Object> mockResponse = new HashMap<>();
        mockResponse.put("id", cliente.getId());
        mockResponse.put("nome", cliente.getNome());
        mockResponse.put("cpf", cliente.getCpf());
        mockResponse.put("email", cliente.getEmail());


        try (MockedStatic<ClientePresenter> mockedStatic = mockStatic(ClientePresenter.class)) {
            mockedStatic.when(() -> ClientePresenter.toObject(any(Cliente.class))).thenReturn(mockResponse);

            mockMvc.perform(post("/clientes")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(cliente)))
                    .andExpect(status().isCreated());
        }
    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        CreateClienteController createClienteController = new CreateClienteController(clienteRepositoryInterface);
        this.mockMvc = MockMvcBuilders.standaloneSetup(createClienteController).build();


        cliente = new Cliente();
        cliente.setId("838b1e25-a271-4816-a16b-a585470d84ed");
        cliente.setNome("Cliente 1");
        cliente.setCpf("12345678901");
        cliente.setEmail("teste@teste.com");


    }

}