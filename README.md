# Sistema de Agendamento de Transferências

Este projeto implementa um sistema de agendamento de transferências financeiras utilizando uma arquitetura tradicional em camadas (Controller, Service e Repository). A aplicação é composta por:

- Uma API REST desenvolvida com **Spring Boot**
- Um front-end desenvolvido com **Vue.js**

## Índice

- [Arquitetura](#arquitetura)
- [Versões Utilizadas](#versões-utilizadas)
- [Decisões Arquiteturais](#decisões-arquiteturais)
- [Configuração e Execução](#configuração-e-execução)
  - [Backend (Spring Boot)](#backend-spring-boot)
  - [Frontend (Vue.js)](#frontend-vuejs)
- [Considerações Finais](#considerações-finais)

## Arquitetura

A aplicação foi desenvolvida seguindo uma abordagem tradicional com as seguintes camadas:

- **Controller:** Responsável por expor os endpoints REST.
- **Service:** Implementa a lógica de negócio, incluindo validações e cálculos (como o cálculo da taxa de transferência).
- **Repository:** Gerencia a persistência dos dados utilizando Spring Data JPA e o banco de dados em memória **H2**.

## Versões Utilizadas

- **Java:** 17 (ou superior)
- **Spring Boot:** 2.6.x (ajuste conforme necessário)
- **Maven:** 3.6.x (ou superior)
- **Node.js:** 14.x (ou superior)
- **Vue CLI:** 4.x ou 5.x

## Decisões Arquiteturais

1. **Camadas Tradicionais:**  
   A separação em camadas (Controller, Service, Repository) facilita a manutenção, testes e escalabilidade da aplicação.

2. **Banco de Dados em Memória:**  
   Utilizamos o H2 para facilitar o desenvolvimento e testes, pois não requer uma configuração complexa de banco de dados.

3. **Comunicação Assíncrona com o Front-end:**  
   O front-end em Vue.js utiliza o Axios para realizar chamadas assíncronas à API, permitindo a atualização dinâmica dos dados.

4. **Eventos para Sincronização:**  
   Após a criação de uma transferência, um evento é emitido para atualizar a listagem de transferências, garantindo que os dados exibidos estejam sempre atualizados.

## Configuração e Execução

### Backend (Spring Boot)

1. **Pré-requisitos:**  
   - Java 17 (ou superior)
   - Maven

2. **Configurações:**  
   - O banco de dados H2 está configurado para rodar em memória.
   - O console do H2 pode ser acessado em: `http://localhost:8080/h2-console`
     - **JDBC URL:** `jdbc:h2:mem:transferdb`
     - **Usuário:** `sa`
     - **Senha:** (em branco)

3. **Execução:**  
   Navegue até a pasta do projeto backend e execute:

   ```bash
   mvn spring-boot:run

A API estará disponível em:
http://localhost:8080/api/transferencias

### Frontend (Vue.js)

#### Pré-requisitos

- **Node.js:** Versão 14.x ou superior.
- **Vue CLI:** Instalado globalmente:

  ```bash
  npm install -g @vue/cli

**Configurações:**
Navegue até a pasta do projeto front-end (por exemplo, agendamento-transferencias) e instale as dependências:

```bash
npm install

A aplicação será iniciada em uma URL como:
http://localhost:8080 (ou conforme configurado).

Integração com a API
Certifique-se de que a URL base do Axios no front-end está apontando para a porta correta onde a API está rodando.
