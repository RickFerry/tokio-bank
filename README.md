# Tokio Bank API

API para agendamento de transferências financeiras, desenvolvida com **Java 11** e **Spring Boot 2.7.1**. A API permite agendar transferências, calcular taxas com base em uma tabela específica e visualizar um extrato de agendamentos.

## 📌 Tecnologias Utilizadas
- Java 11
- Spring Boot 2.7.0
- Spring Data JPA
- Lombok
- H2 Database
- Maven

## 📂 Estrutura do Projeto
```
tokio-bank/
│── src/
│   ├── main/
│   │   ├── java/com/tokiobank/
│   │   │   ├── TokioBankApplication.java
│   │   │   ├── controller/
│   │   │   │   ├── TransferenciaController.java
│   │   │   ├── model/
│   │   │   │   ├── Transferencia.java
│   │   │   │   ├── TaxaEnum.java
│   │   │   ├── repository/
│   │   │   │   ├── TransferenciaRepository.java
│   │   │   ├── service/
│   │   │   │   ├── TransferenciaService.java
│   │   │   ├── exception/
│   │   │   │   ├── TaxaInvalidaException.java
│   │   ├── resources/
│   │   │   ├── application.yml
│   ├── test/
│       ├── java/com/tokiobank/
│       │   ├── TransferenciaServiceTest.java
```

## 🚀 Como Executar o Projeto
### 1️⃣ **Clonar o repositório**
```sh
git clone https://github.com/seu-usuario/tokio-bank.git
cd tokio-bank
```

### 2️⃣ **Compilar e Executar**
```sh
mvn spring-boot:run
```
A API estará disponível em: **http://localhost:8080**

## 📌 Endpoints Disponíveis
### **1. Agendar Transferência**
- **Método:** `POST`
- **Endpoint:** `/transferencias`
- **Exemplo de Payload:**
```json
{
  "contaOrigem": "1234567890",
  "contaDestino": "0987654321",
  "valor": 1000.00,
  "dataTransferencia": "2025-03-10"
}
```
- **Resposta:**
```json
{
  "id": 1,
  "contaOrigem": "1234567890",
  "contaDestino": "0987654321",
  "valor": 1000.00,
  "taxa": 82.00,
  "dataTransferencia": "2025-03-10",
  "dataAgendamento": "2025-02-12"
}
```

### **2. Listar Transferências Agendadas**
- **Método:** `GET`
- **Endpoint:** `/transferencias`
- **Resposta:** Lista de transferências agendadas.

## 🛠️ Configuração do Banco de Dados (H2)
A API utiliza o banco de dados em memória **H2**. Acesse o console do banco em:
> **http://localhost:8080/h2-console**

### **Configuração no `application.yml`**
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:tokio_bank
    driverClassName: org.h2.Driver
    username: sa
    password:
  h2:
    console:
      enabled: true
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
```

## 🛠️ Testes
Para rodar os testes unitários:
```sh
mvn test
```

---

