#language: pt

   Funcionalidade: : Cadastro de cliente
     Cenario: Cadastro de cliente
       Dado que tenho um cliente válido, com os dados preenchidos corretamente
       E envio uma requisição POST para criar o cliente
       Entao o sistema deve retornar o status created