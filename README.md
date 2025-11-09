# 🎮 Sistema de Gerenciamento de Jogos – Spring Boot

Um projeto simples em **Spring Boot** que realiza operações **CRUD** (Create, Read, Update e Delete) sobre um arquivo JSON que simula um banco de dados.  
Feito para fins acadêmicos na **Faculdade FECAF**, com foco em consolidar conceitos de API REST, serialização e persistência de dados locais.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.7**
- **Maven** (gerenciador de dependências)
- **Jackson Databind** (para leitura e escrita de JSON)
- **Jakarta Annotations (@PostConstruct)**

---

## 🧩 Estrutura do Projeto

```
📦 fecaf-jogos-spring
 ┣ 📂 src/main/java/br/com/fecaf
 ┃ ┣ 📜 App.java
 ┃ ┣ 📂 controller
 ┃ ┃ ┗ 📜 JogoController.java
 ┃ ┣ 📂 model
 ┃ ┃ ┗ 📜 Jogo.java
 ┃ ┣ 📂 database
 ┃ ┃ ┗ 📜 jogos.json
 ┗ 📜 pom.xml
```

---

## ⚙️ Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/thiago-fischer/fecaf-jogos-spring.git
   cd fecaf-jogos-spring
   ```

2. **Executar via Maven ou IntelliJ/Eclipse:**
   ```bash
   mvn spring-boot:run
   ```

3. A aplicação iniciará em:
   ```
   http://localhost:8080/api/v1/jogos
   ```

---

## 📚 Descrição das Funcionalidades

O sistema lê os dados do arquivo `database/jogos.json` ao iniciar (com `@PostConstruct`) e mantém uma lista de objetos `Jogo` em memória.  
Cada alteração (criação, edição ou exclusão) atualiza automaticamente o arquivo JSON.

---

## 🧠 Endpoints Disponíveis

### 🔹 `GET /api/v1/jogos`
Retorna **todos os jogos** cadastrados.

**Exemplo de resposta:**
```json
[
  {
    "id" : 1,
    "anoLancamento" : 2015,
    "vendas" : 50000000,
    "titulo" : "The Witcher 3: Wild Hunt",
    "desenvolvedora" : "CD Projekt Red",
    "genero" : "RPG",
    "plataforma" : "PC",
    "classificacao" : "18+",
    "status" : "Disponível",
    "preco" : 149.9,
    "nota" : 9.8
  }
]
```

---

### 🔹 `GET /api/v1/jogos/{id}`
Busca um jogo específico pelo **ID**.

**Retornos possíveis:**
- `200 OK` → Jogo encontrado  
- `404 Not Found` → ID inexistente

---

### 🔹 `POST /api/v1/jogos`
Adiciona um **novo jogo**.  
O ID é gerado automaticamente com base no maior valor existente.

**Exemplo de requisição:**
```json
{
  "anoLancamento" : 2018,
  "vendas" : 23000000,
  "titulo" : "God of War",
  "desenvolvedora" : "Santa Monica Studio",
  "genero" : "Ação/Aventura",
  "plataforma" : "PlayStation 4",
  "classificacao" : "18+",
  "status" : "Disponível",
  "preco" : 199.9,
  "nota" : 9.7
}
```

**Retorno:**  
`200 OK` com o novo jogo em JSON.

---

### 🔹 `PUT /api/v1/jogos`
Edita as informações de um jogo já existente (busca pelo ID).

**Exemplo de requisição:**
```json
{
  "id" : 3,
  "anoLancamento" : 2018,
  "vendas" : 58000000,
  "titulo" : "Red Dead Redemption 2",
  "desenvolvedora" : "Rockstar Games",
  "genero" : "Ação/Aventura",
  "plataforma" : "PlayStation 4",
  "classificacao" : "18+",
  "status" : "Disponível",
  "preco" : 249.9,
  "nota" : 9.8
}
```

**Retornos possíveis:**
- `200 OK` → Atualizado com sucesso  
- `404 Not Found` → Jogo não encontrado  

---

### 🔹 `DELETE /api/v1/jogos/{id}`
Remove um jogo do arquivo JSON.

**Retornos possíveis:**
- `204 No Content` → Removido com sucesso  
- `404 Not Found` → ID não existe  

---

## 💾 Persistência de Dados

- O arquivo `jogos.json` atua como **banco de dados local**.
- Os dados são carregados na inicialização e salvos novamente a cada modificação.
- Ordenação automática dos jogos por **ID** durante a gravação (para manter o arquivo organizado).

---

## 🧩 Classe Principal: `App.java`

Inicia o servidor Spring Boot com:
```java
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
```

---

## 🧱 Controller Principal: `JogoController.java`

Responsável por todas as rotas REST.  
- Usa `@PostConstruct` para carregar o JSON.  
- Implementa métodos para leitura, escrita e exclusão dos dados.  
- Utiliza `ResponseEntity` para controlar os retornos HTTP.

---

## 🧠 Conceitos Aplicados

- Arquitetura **RESTful**
- Manipulação de arquivos JSON
- Serialização e desserialização com **Jackson**
- Controle de resposta HTTP com `ResponseEntity`
- Boas práticas de código e uso de Streams API


---

## 👨‍💻 Autor

**Thiago Pedrozo Bauerman Fischer — Estudante de Engenharia da Computação**  
📘 Projeto acadêmico desenvolvido para prática de **APIs REST com Spring Boot**.
