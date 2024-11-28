package org.example.client.bdd;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.example.client.application.controllers.cliente.create.requests.ClienteCreateRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
public class StepDefinition {

    private static final String ENDPOINT = "http://localhost:8080/clientes";  // Endpoint para a criação do cliente
    private ClienteCreateRequest cliente;
    private ResponseEntity<String> response;
    private MockMvc mockMvc;
    RestTemplate restTemplate = new RestTemplate();

    @Dado("que tenho um cliente válido, com os dados preenchidos corretamente")
    public void dadoQueUmClienteValidoComOsDadosPreenchidosCorretamente() {
        cliente = new ClienteCreateRequest("João da Silva", "12345678901", "teste@mail.com");
    }

    @E("envio uma requisição POST para criar o cliente")
    public void quandoEuEnvioUmaRequisicaoPostParaCriarOCliente() {

        HttpEntity<ClienteCreateRequest> request = new HttpEntity<>(cliente);
            response = restTemplate.exchange(ENDPOINT, HttpMethod.POST, request, String.class);
            var response2 = response;
    }

    @Entao("o sistema deve retornar o status created")
    public void o_sistema_deve_retornar_o_status_criado_com_sucesso() {
        int value = response.getStatusCode().value();
        assertEquals(201, value);

    }
}
