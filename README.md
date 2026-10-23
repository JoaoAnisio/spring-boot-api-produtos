# Exercícios Spring Boot

Meu primeiro projeto com Java e Spring Boot, desenvolvido durante um curso. Ele reúne exercícios de controllers REST, métodos HTTP, parâmetros de rota e de query, e um CRUD de produtos com JPA e MySQL.

## Tecnologias

- Java 21
- Spring Boot 3.2 (Web, Data JPA, Validation, DevTools)
- MySQL
- Maven
- JUnit 5 + H2 (banco em memória para os testes)

## Como rodar

Pré-requisitos: Java 21 e um MySQL rodando com um banco chamado `springboot`.

```bash
export DB_PASSWORD=sua_senha
# opcionais: DB_USER (padrão: root) e DB_URL (padrão: jdbc:mysql://localhost:3306/springboot)

./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`. A tabela de produtos é criada automaticamente.

Para rodar os testes (não precisa de MySQL):

```bash
./mvnw test
```

## Endpoints

### Produtos (`/api/produtos`)

| Método | Rota | Descrição |
|---|---|---|
| POST / PUT | `/api/produtos` | Cria ou atualiza um produto (JSON) |
| GET | `/api/produtos` | Lista todos os produtos |
| GET | `/api/produtos/{id}` | Busca por id (404 se não existir) |
| GET | `/api/produtos/nome/{parteNome}` | Busca produtos cujo nome contém o texto |
| GET | `/api/produtos/pagina/{numPag}/{qtdePag}` | Lista paginada (máx. 5 por página) |
| DELETE | `/api/produtos/{id}` | Remove um produto (404 se não existir) |

Exemplo de corpo para criar um produto:

```json
{
  "nome": "Notebook",
  "preco": 3500.00,
  "desconto": 0.1
}
```

Regras de validação: `nome` obrigatório, `preco` ≥ 0 e `desconto` entre 0 e 1.

### Outros exercícios

| Método | Rota | Descrição |
|---|---|---|
| GET | `/ola` e `/saudacao` | Mensagens de boas-vindas |
| GET | `/calculadora/somar/{a}/{b}` | Soma com parâmetros de rota |
| GET | `/calculadora/subtrair?a=&b=` | Subtração com parâmetros de query |
| GET | `/clientes/qualquer`, `/clientes/{id}`, `/clientes?id=` | Retorno de objetos em JSON |
| GET, POST, PUT, PATCH, DELETE | `/metodos` | Demonstração dos métodos HTTP |

Também há um formulário simples em `http://localhost:8080/formulario.html` que envia um POST para `/metodos`.
