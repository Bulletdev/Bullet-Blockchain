# Blockchain com Autenticação JWT em Java

Este projeto implementa uma blockchain básica com autenticação JWT, usando Spring Boot e Java. A aplicação permite autenticação de usuários, criação e verificação de transações, mineração de blocos e sincronização P2P. O sistema é persistido em um banco de dados e garante a integridade dos dados com Proof of Work e assinaturas digitais.

## ✨ Funcionalidades

- **Autenticação JWT**: Protege endpoints com JSON Web Tokens.
- **Mineração de Blocos**: Realiza mineração usando Proof of Work com ajuste de dificuldade.
- **Assinaturas Digitais**: Garante a autenticidade das transações com criptografia assimétrica.
- **Persistência em Banco de Dados**: Blockchain salva no banco H2 para durabilidade.
- **Rede P2P**: Suporte inicial para rede peer-to-peer com comunicação de novos blocos.
  
## 🛠 Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.5.4**
- **JWT (Json Web Token)**
- **Bouncy Castle** (para assinaturas digitais)
- **H2 Database**
- **Spring Data JPA**
  
## ⚙️ Configuração e Instalação

### Pré-requisitos

Certifique-se de ter o [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) e o [Maven](https://maven.apache.org/) instalados em sua máquina.

### Passo a Passo

1. **Clone o Repositório**

    ```bash
    git clone https://github.com/seuusuario/blockchain-jwt-java.git
    cd blockchain-jwt-java
    ```

2. **Configuração do Banco de Dados**

   O projeto está configurado para usar um banco de dados em memória (H2). Verifique as configurações em `src/main/resources/application.properties`:
   
   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.h2.console.enabled=true
   spring.jpa.show-sql=true
   spring.jpa.hibernate.ddl-auto=update


Instale as Dependências

Execute o Maven para baixar todas as dependências:


mvn install
Execute a Aplicação

Inicie o servidor:


mvn spring-boot:run
Acesse o Console H2 (opcional)

URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb

Username: sa
Password: (deixe vazio)

🌐 Endpoints da API

Autenticação
Registro de Usuário
http

POST /auth/register
Body: { "username": "user1", "password": "senha123" }
Login
http
Copiar código
POST /auth/login
Body: { "username": "user1", "password": "senha123" }
Retorno: { "token": "jwt_token" }
Blockchain

Ver Blockchain Completa
http

GET /blockchain/chain
Headers: Authorization: Bearer {token}

Criar Nova Transação
http

POST /blockchain/transaction
Headers: Authorization: Bearer {token}
Body: { "sender": "public_key", "recipient": "public_key", "value": 10 }
Minerar Bloco
http

POST /blockchain/mine
Headers: Authorization: Bearer {token}
Retorno: Bloco recém-minerado

🗂 Estrutura do Projeto



src
├── main
│   ├── java
│   │   └── com.example.blockchain
│   │       ├── model            # Classes de modelo (Block, Transaction, Wallet)
│   │       ├── repository       # Repositórios JPA
│   │       ├── service          # Lógica de mineração e blockchain
│   │       ├── controller       # Controladores de API para Blockchain e Auth
│   │       └── config           # Configuração de segurança JWT
│   └── resources
│       └── application.properties # Configuração do Spring Boot



📝 Licença

BulletDEV all rights reserveds !