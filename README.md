# ReciclaVille_API

**ReciclaVille_API** é uma plataforma desenvolvida para facilitar o gerenciamento da compensação de carbono por empresas parceiras. O sistema permite o cadastro de declarações sobre materiais utilizados, o cálculo da compensação necessária e a visualização de dados para uma gestão ambiental mais eficiente.

---

## Objetivo

Permitir que empresas registrem suas declarações de uso de materiais de embalagem e calculem automaticamente a quantidade de material a ser reciclado para compensar o impacto ambiental.

---

## Funcionalidades

- Cadastro de Clientes (empresas)
- Cadastro de Materiais com percentual de compensação
- Registro de Declarações com período e itens declarados
- Cálculo automático de:
  - Total de toneladas declaradas
  - Toneladas a compensar com base no material
- Atualização e exclusão de declarações
- Retorno de dados no formato JSON para consumo em front-ends ou integrações

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot (API REST)
- Hibernate/JPA (ORM para banco de dados)
- Lombok (redução de código boilerplate)
- PostgreSQL
- ModelMapper (conversão entre entidades e DTOs)
- Bean Validation (Jakarta Validation para validação de dados)

---

## Estrutura de Pastas

ReciclaVille_API/
- controller/           (Camada de controle, endpoints REST)
- service/              (Regras de negócio)
- repository/           (Interfaces para acesso ao banco de dados)
- model/
  - entity/             (Entidades JPA)
  - dtos/               (Objetos de transferência de dados)
- config/               (Configurações do projeto, ex: CORS, ModelMapper)
- exception/            (Tratamento customizado de exceções)
- resources/
  - application.properties (Configurações do Spring Boot)

---
## Endpoints Principais

### Clientes
- GET /Clientes  
- GET /Clientes/{id}  
- POST /Clientes  
- PUT /Clientes/{id}  
- DELETE /Clientes/{id}  

### Materiais
- GET /Materiais  
- GET /Materiais/{id}  
- POST /Materiais  
- PUT /Materiais/{id}  
- DELETE /Materiais/{id}  

### Declarações
- GET /Declaracoes  
- GET /Declaracoes/{id}  
- POST /Declaracoes  
- DELETE /Declaracoes/{id}  

### Dashboard
- GET /Dashboard

---

## Exemplo de POST Declaração:

```json
{
  "cliente": {
    "id": 2
  },
  "dataInicialPeriodo": "2025-05-01",
  "dataFinalPeriodo": "2025-05-10",
  "itensDeclaracao": [
    {
      "material": {
        "id": 2
      },
      "toneladasDeclaradas": 50.5
    },
    {
      "material": {
        "id": 3
      },
      "toneladasDeclaradas": 30.0
    },
    {
      "material": {
        "id": 4
      },
      "toneladasDeclaradas": 20.0
    }
  ]
}
```
---

## Validações Importantes

- Datas de início devem ser anteriores às datas finais
- Toneladas declaradas devem ser maiores que zero
- Cliente e materiais devem existir no banco de dados
- Percentual de compensação é atribuído automaticamente com base no material

---

## Como executar localmente

1. Clone o repositório com o comando:

   git clone https://github.com/seuusuario/ReciclaVille_API.git

2. Abra o projeto em uma IDE Java (IntelliJ IDEA, VSCode, Eclipse)

3. Execute a aplicação iniciando a classe principal anotada com `@SpringBootApplication`

4. Acesse a API pelo navegador ou ferramenta REST (ex: Postman):

   http://localhost:8080

---

## Autor

Desenvolvido por Marcos Vinicius Santos da Silva, como projeto educacional para gestão de compensação ambiental.

---

## Licença

Projeto para uso educacional sem licença formal definida. 
