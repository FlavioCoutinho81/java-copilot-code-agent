# Sistema de Gestão Escolar - Mergington High School

Sistema de gestão de atividades extracurriculares desenvolvido com Spring Boot e arquitetura limpa (Clean Architecture).

> **📋 Última Atualização**: Esta documentação foi atualizada para refletir as funcionalidades mais recentes, incluindo categorização automática de atividades, sistema de autenticação aprimorado e novos endpoints.

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

#### Categorização Automática

O sistema possui um algoritmo inteligente que categoriza automaticamente as atividades baseado em palavras-chave do nome e descrição:

- **Palavras-chave de Esportes**: futebol, basquete, esporte, fitness, equipe, time, jogo, atlético
- **Palavras-chave de Artes**: arte, música, teatro, drama, criativo, pintura, manga
- **Palavras-chave Acadêmicas**: ciência, matemática, acadêmico, estudo, olimpíada, aprendizado, educação
- **Palavras-chave de Comunidade**: voluntário, comunidade, serviço
- **Palavras-chave de Tecnologia**: computador, programação, tecnologia, robótica, digital, robô

> **Nota**: Se nenhuma palavra-chave for encontrada, a atividade é categorizada como "Acadêmico" por padrão.

### 👨‍🏫 Sistema de Autenticação

- **Login de professores** com username/senha via `/auth/login`
- **Verificação de sessão** via `/auth/check-session`
- **Controle de acesso** baseado em roles (TEACHER/ADMIN)
- **Autenticação requerida** para inscrições e cancelamentos
- **Criptografia Argon2** para senhas seguras

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
# Login do professor
POST /auth/login
Content-Type: application/x-www-form-urlencoded

username=mrodriguez&password=art123

# Resposta de sucesso:
{
  "username": "mrodriguez",
  "name": "Sr. Rodriguez",
  "role": "TEACHER"
}

# Verificar sessão
GET /auth/check-session?username=mrodriguez

# Resposta de sucesso:
{
  "username": "mrodriguez", 
  "name": "Sr. Rodriguez",
  "role": "TEACHER"
}
```

#### Inscrições

```http
# Inscrever estudante em atividade
POST /activities/{activityName}/signup
Content-Type: application/x-www-form-urlencoded

email=student@mergington.edu&teacher_username=mrodriguez

# Cancelar inscrição
POST /activities/{activityName}/unregister
Content-Type: application/x-www-form-urlencoded

email=student@mergington.edu&teacher_username=mrodriguez
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

- **mrodriguez** (Sr. Rodriguez) - Professor de artes, senha padrão: `art123`
- **mchen** (Sra. Chen) - Professora de xadrez, senha padrão: `chess123`  
- **principal** (Diretor Martinez) - Administrador principal, senha padrão: `admin123`

> **Nota**: As senhas podem ser configuradas via variáveis de ambiente: `TEACHER_RODRIGUEZ_PASSWORD`, `TEACHER_CHEN_PASSWORD`, `PRINCIPAL_PASSWORD`

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

## 📝 Changelog

### ✨ Novas Funcionalidades Recentes

#### 🏷️ Sistema de Categorização de Atividades
- **ActivityType Enum**: Categorização automática em 5 tipos (SPORTS, ARTS, ACADEMIC, COMMUNITY, TECHNOLOGY)
- **Cores personalizadas** para cada tipo de atividade na interface
- **Algoritmo inteligente** de categorização baseado em palavras-chave

#### 🔐 Sistema de Autenticação Aprimorado  
- **Novos endpoints** `/auth/login` e `/auth/check-session`
- **DTOs dedicados** para requisições de login
- **Verificação de sessão** para validação de estado de autenticação

#### 🎭 Nova Atividade: Manga Maniacs
- **Migração V002**: Adicionada atividade focada em cultura manga japonesa
- **Horário especializado**: Terças-feiras, 19:00-20:00
- **Categoria**: Artes com descrição envolvente

#### 📊 Estrutura de Resposta da API Atualizada
- **ActivityDTO aprimorado** com informações de tipo e cores
- **Dados mais ricos** para renderização na interface
- **Compatibilidade mantida** com versões anteriores
