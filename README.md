# Pos Tech Lanchonete

Projeto desenvolvido para o Tech Challenge da Pos Tech FIAP+Alura.

## Como testar a aplicação com kubernetes

Faça download do projeto e na pasta principal rode os comandos no terminal para cada arquivo, seguindo a ordem:

Banco de dados:
```bash
   kubectl apply -f ./k8s/db/<file>.yaml 
```
Arquivos para banco de dados:

    1. db-secret.yaml
    2. pv.yaml
    3. pvc.yaml
    4. db-service.yaml
    5. db-deployment.yaml
Aplicação:
```bash
   kubectl apply -f ./k8s/app/<file>.yaml 
```
Arquivos para aplicação:

    5. service.yaml
    6. deployment.yaml

## Como testar a aplicação com docker compose

Faça download do projeto e na pasta principal rode o comando no terminal:

```bash
   docker-compose --env-file exemplo.env up -d
```
No navegador, abra a pagina do Swagger da aplicação:
http://localhost:8080/lanchonete/swagger-ui/index.html#/

O Swagger está documentado com exemplos de request.

### Opção de fluxo, usando o swagger

Cria um cliente com cpf valido
- POST /clientes
  
Verificar os produtos disponiveis e seus respectivos ids para o pedido
- GET /produtos 

Criar pedido com produtos e quantidade de itens desejados e cliente cadastrado. Para pedidos sem cliente, passar o cpf como nulo ou uma string vazia. ("")
- POST /pedidos

Listar Pedidos - O pedido recem criado não será listado, por não estar pago ainda
- GET /pedidos

Utilizar o serviço de verificação de pagamento realizado ou pendente.
- GET /pedidos/{pedidoId}/pagamento

Utilizar o serviço de recebimento de pagamento realizado.
- POST /pedidos/{pedidoId}/pagamento

Validar se o pagamento foi realizado com sucesso.
- GET /pedidos/{pedidoId}/pagamento

Listar Pedidos - O pedido deve ser listado, após etapa de pagamento
- GET /pedidos

Avançar o status do pedido
- PATCH /pedidos/{pedidoId}/atualizar

Id dos status:

2 - Recebido | 3 - Em preparação | 4 - Pronto | 5 - Finalizado


A aplicação é iniciada com dados de categorias, produtos e status no banco de dados.
## Stack utilizada

**Banco de dados:** Mysql

**Back-end:** Java, Springboot


## Autores

- [Diego B Brito](https://github.com/Diegobbrito)
- [Gustavo Joia](https://github.com/GustavoJoiaP)