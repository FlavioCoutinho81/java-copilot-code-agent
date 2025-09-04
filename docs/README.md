# Sistema de Gestão Escolar - Mergington High School

Sistema de gestão de atividades extracurriculares desenvolvido com Spring Boot e arquitetura limpa (Clean Architecture).

## 📋 Visão Geral

O **School Management System** é uma aplicação web que permite o gerenciamento de atividades extracurriculares da Mergington High School. O sistema possibilita que professores administrem atividades e que estudantes se inscrevam nelas através de uma interface web intuitiva.

## 🏗️ Arquitetura

### Princípios Arquiteturais

- **Clean Architecture**: Separação clara entre camadas de domínio, aplicação, infraestrutura e apresentação
- **Domain-Driven Design (DDD)**: Modelagem focada no domínio escolar
- **SOLID Principles**: Código bem estruturado e extensível
- **Hexagonal Architecture**: Isolamento das regras de negócio

### Estrutura de Camadas

```text
src/main/java/com/mergingtonhigh/schoolmanagement/
├── domain/                    # 🎯 Camada de Domínio
│   ├── entities/             # Entidades principais
│   │   ├── Activity.java     # Atividade extracurricular
│   │   └── Teacher.java      # Professor/Administrador
│   ├── repositories/         # Interfaces de repositório
│   │   ├── ActivityRepository.java
│   │   └── TeacherRepository.java
│   └── valueobjects/         # Objetos de valor
│       ├── ActivityType.java       # ✨ Novo: Categorização de atividades
│       ├── Email.java        # Validação de email
│       └── ScheduleDetails.java # Detalhes de horário
├── application/              # 🔧 Camada de Aplicação
│   ├── dtos/                 # Data Transfer Objects
│   │   ├── ActivityDTO.java
│   │   ├── ActivityTypeDTO.java    # ✨ Novo: Tipos de atividade
│   │   ├── LoginRequestDTO.java    # ✨ Novo: Request de login
│   │   ├── StudentRegistrationDTO.java
│   │   └── TeacherDTO.java
│   └── usecases/             # Casos de uso
│       ├── ActivityUseCase.java
│       ├── AuthenticationUseCase.java  # ✨ Novo: Autenticação
│       └── StudentRegistrationUseCase.java
├── infrastructure/           # 🏭 Camada de Infraestrutura
│   ├── config/               # Configurações
│   ├── migrations/           # Migrações do banco
│   │   ├── V001_InitialDatabaseSetup.java
│   │   └── V002_AddMangaManiacsClub.java    # ✨ Novo: Clube Manga Maniacs
│   └── persistence/          # Implementações de repositório
│       ├── ActivityRepositoryImpl.java
│       ├── MongoActivityRepository.java
│       ├── MongoTeacherRepository.java
│       └── TeacherRepositoryImpl.java
└── presentation/             # 🎨 Camada de Apresentação
    ├── controllers/          # Controllers REST
    │   ├── ActivityController.java
    │   ├── AuthController.java     # ✨ Novo: Autenticação
    │   └── StaticController.java   # ✨ Novo: Conteúdo estático
    └── mappers/              # Mapeadores DTO ↔ Entity
        ├── ActivityMapper.java
        └── TeacherMapper.java
```

## 🚀 Tecnologias Utilizadas

### Backend

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.4** - Framework principal
- **Spring Data MongoDB** - Integração com MongoDB
- **Spring Security** - Autenticação e autorização
- **Spring Web** - APIs REST
- **Spring Validation** - Validação de dados
- **Mongock 5.5.1** - Migrações do banco de dados
- **BouncyCastle** - Criptografia para senhas

### Frontend

- **HTML5/CSS3/JavaScript** - Interface web
- **Vanilla JavaScript** - Interatividade do frontend

### Banco de Dados

- **MongoDB** - Banco de dados NoSQL

### Ferramentas de Desenvolvimento

- **Maven** - Gerenciamento de dependências
- **JUnit 5** - Testes unitários
- **Mockito** - Mocks para testes
- **Testcontainers** - Testes de integração
- **Jacoco** - Cobertura de testes

## 📦 Funcionalidades Principais

### 🎓 Gestão de Atividades

- **Listagem de atividades** com filtros por:
  - Dia da semana
  - Horário (manhã, tarde, fim de semana)
  - Categoria (esportes, artes, acadêmico, etc.)
- **Detalhes de atividades**:
  - Nome e descrição
  - Horários e dias da semana
  - Capacidade máxima
  - Lista de participantes
  - **✨ Tipo/Categoria da atividade** com cores visuais

### 🏷️ Categorização de Atividades

O sistema agora categoriza automaticamente as atividades em 5 tipos principais:

- **🏃 Esportes** (SPORTS): Atividades físicas, jogos em equipe, fitness
  - Cor: Verde claro (#e8f5e9) com texto verde escuro (#2e7d32)
  - Exemplos: Futebol, Basquete, Fitness

- **🎨 Artes** (ARTS): Atividades criativas e culturais
  - Cor: Roxo claro (#f3e5f5) com texto roxo escuro (#7b1fa2)
  - Exemplos: Teatro, Música, Manga Maniacs

- **📚 Acadêmico** (ACADEMIC): Atividades educacionais e competitivas
  - Cor: Azul claro (#e3f2fd) com texto azul escuro (#1565c0)
  - Exemplos: Olimpíada de Matemática, Clube de Ciências

- **🤝 Comunidade** (COMMUNITY): Atividades de serviço e voluntariado
  - Cor: Laranja claro (#fff3e0) com texto laranja escuro (#e65100)
  - Exemplos: Trabalho voluntário, Projetos comunitários

- **💻 Tecnologia** (TECHNOLOGY): Atividades relacionadas à tecnologia
  - Cor: Índigo claro (#e8eaf6) com texto índigo escuro (#3949ab)
  - Exemplos: Programação, Robótica, Computação

### 👨‍🏫 Sistema de Autenticação

- **Login de professores** com username/senha
- **Controle de acesso** baseado em roles (TEACHER/ADMIN)
- **Autenticação requerida** para inscrições

### 📝 Gestão de Inscrições

- **Inscrição de estudantes** em atividades
- **Cancelamento de inscrições**
- **Validações**:
  - Capacidade máxima
  - Duplicatas
  - Autenticação do professor

### 🎨 Interface Web

- **Design responsivo** e intuitivo
- **Filtros dinâmicos** para busca de atividades
- **Modais** para login e inscrições
- **Feedback visual** para ações do usuário

## 🔧 Configuração e Execução

### Pré-requisitos

- Java 21
- Maven 3.8+
- MongoDB 4.4+

### Variáveis de Ambiente

Crie um arquivo `.env` baseado no `.env.example`

### Executando o Projeto

1. **Iniciar MongoDB**:

   ```bash
   # Docker
   docker run -d -p 27017:27017 --name mongodb mongo:latest
   
   # Ou MongoDB local
   mongod
   ```

2. **Compilar e executar**:

   ```bash
   # Compilar o projeto
   mvn clean compile
   
   # Executar os testes
   mvn test
   
   # Iniciar a aplicação
   mvn spring-boot:run
   ```

3. **Acessar a aplicação**:
   - Frontend: <http://localhost:8080>
   - API REST: <http://localhost:8080/activities>

### Tasks Maven Disponíveis

- `mvn clean install` - Build completo
- `mvn test` - Executar testes
- `mvn spring-boot:run` - Iniciar aplicação
- `mvn package -DskipTests` - Gerar JAR

## 🌐 API REST

### Endpoints Principais

#### Atividades

```http
GET /activities
GET /activities?day=Monday&start_time=15:00&end_time=17:00
GET /activities/days
```

#### ✨ Autenticação

```http
POST /auth/login
Content-Type: application/x-www-form-urlencoded

username=teacher1&password=secret

GET /auth/check-session?username=teacher1
```

#### Inscrições

```http
POST /activities/{activityName}/signup
Content-Type: application/x-www-form-urlencoded

email=student@mergington.edu&teacher_username=teacher1

POST /activities/{activityName}/unregister
Content-Type: application/x-www-form-urlencoded

email=student@mergington.edu&teacher_username=teacher1
```

### Exemplo de Resposta - ✨ Estrutura Atualizada

#### GET /activities

```json
{
  "Chess Club": {
    "name": "Chess Club",
    "description": "Desenvolva estratégia e pensamento crítico...",
    "schedule": "Mondays and Wednesdays, 15:30 - 17:00",
    "scheduleDetails": {
      "days": ["Monday", "Wednesday"],
      "startTime": "15:30",
      "endTime": "17:00"
    },
    "maxParticipants": 20,
    "participants": ["student1@mergington.edu"],
    "currentParticipantCount": 1,
    "type": {
      "name": "ACADEMIC",
      "label": "Acadêmico",
      "color": "#e3f2fd",
      "textColor": "#1565c0"
    }
  },
  "Manga Maniacs": {
    "name": "Manga Maniacs",
    "description": "Mergulhe no incrível universo dos mangás japoneses!...",
    "schedule": "Terças-feiras, 19:00 - 20:00",
    "scheduleDetails": {
      "days": ["Tuesday"],
      "startTime": "19:00",
      "endTime": "20:00"
    },
    "maxParticipants": 15,
    "participants": [],
    "currentParticipantCount": 0,
    "type": {
      "name": "ARTS",
      "label": "Artes",
      "color": "#f3e5f5",
      "textColor": "#7b1fa2"
    }
  }
}
```

## 🧪 Testes

### Estrutura de Testes

```text
src/test/java/
├── application/usecases/     # Testes de casos de uso
├── domain/entities/          # Testes de entidades
└── integration/             # Testes de integração
```

### Executar Testes

```bash
# Todos os testes
mvn test

# Testes específicos
mvn test -Dtest=ActivityTest
mvn test -Dtest=StudentRegistrationUseCaseTest

# Com cobertura
mvn jacoco:report
```

## 📊 Dados Iniciais

O sistema utiliza **Mongock** para realizar migrações automáticas do banco de dados, incluindo:

### Professores Padrão

- **admin** - Administrador principal
- **teacher.rodriguez** - Professor de artes
- **teacher.chen** - Professor de xadrez

### Atividades Exemplo

- **Art Club** - Terças e quintas, 15:30-17:00 (Tipo: ARTS)
- **Chess Club** - Segundas e quartas, 15:30-17:00 (Tipo: ACADEMIC)
- **Drama Club** - Quartas e sextas, 16:00-18:00 (Tipo: ARTS)
- **✨ Manga Maniacs** - Terças, 19:00-20:00 (Tipo: ARTS) - *Novo clube para exploração da cultura manga japonesa*

## 🔒 Segurança

- **Autenticação HTTP Basic** para endpoints administrativos
- **Criptografia Argon2** para senhas
- **Validação de dados** em todas as camadas
- **CORS** configurado para desenvolvimento

## 📈 Monitoramento

- **Spring Actuator** - Métricas da aplicação
- **Logs estruturados** - Nível DEBUG para desenvolvimento
- **Health checks** - Status da aplicação e banco

## 🚀 Deploy

### Perfis de Ambiente

- **dev** - Ambiente de desenvolvimento
