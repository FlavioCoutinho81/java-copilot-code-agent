---
name: "🔐 Problemas de Acesso e Autenticação"
about: "Reportar problemas com login, senhas ou permissões de acesso ao sistema"
title: "[ACESSO] "
labels: ["bug", "autenticacao", "professor-request"]
assignees: ["@copilot"]
---

## 🔐 Tipo de Problema de Acesso

**Categoria do Problema:**
- [ ] 🚫 Não consegue fazer login
- [ ] 🔄 Precisa redefinir senha
- [ ] ⚠️ Conta bloqueada ou suspensa
- [ ] 🔑 Problema com validação de credenciais
- [ ] 👥 Problema de permissões (acesso negado)
- [ ] 🆕 Precisa criar nova conta de professor
- [ ] 🔓 Logout automático inesperado
- [ ] 🌐 Problema de acesso à interface web

## 👤 Informações da Conta

**Nome de Usuário:**
<!-- Ex: mrodriguez, mchen, principal -->

**Nome Completo:**
<!-- Ex: Sr. Rodriguez, Sra. Chen, Diretor Martinez -->

**Tipo de Conta:**
- [ ] Professor Regular (TEACHER)
- [ ] Administrador (ADMIN/Principal)
- [ ] Não sei/Incerto

## 🔍 Detalhes do Problema

### Descrição do Incidente
**O que aconteceu:**
<!-- Descreva exatamente o que ocorreu -->

**Mensagem de Erro:** (se aplicável)
```
Cole aqui a mensagem de erro exata
```

**Quando começou o problema:**
<!-- Data/horário aproximado -->

### Tentativas de Login
**Dados Utilizados:**
- **Usuário:** <!-- Nome de usuário tentado -->
- **Método:** 
  - [ ] Formulário web padrão
  - [ ] API direta
  - [ ] Outro método

**Resultados Observados:**
- [ ] Mensagem "Credenciais inválidas"
- [ ] Página não carrega
- [ ] Redirecionamento inesperado
- [ ] Erro 401 (Não autorizado)
- [ ] Erro 500 (Erro interno do servidor)
- [ ] Outro: <!-- Especificar -->

## 🖥️ Ambiente Técnico

**Navegador/Cliente:**
<!-- Chrome, Firefox, Edge + versão -->

**URL de Acesso:**
<!-- Ex: http://localhost:8080/auth/login -->

**Sistema Operacional:**
<!-- Windows, Mac, Linux -->

## ✅ Critérios de Aceitação para Resolução

- [ ] Problema de autenticação identificado e corrigido
- [ ] AuthenticationUseCase funcionando corretamente
- [ ] Validação de credenciais operacional
- [ ] Encoding Argon2 de senhas funcionando
- [ ] Response HTTP adequado (200 para sucesso, 401 para falha)
- [ ] Professor consegue acessar sistema normalmente
- [ ] Permissões de role (TEACHER/ADMIN) funcionando
- [ ] Interface web carrega corretamente após login
- [ ] Sessão mantida adequadamente

## 🔧 Contexto Técnico para Investigação

### Componentes de Autenticação
**Use Case:** AuthenticationUseCase
**Entity:** Teacher (username, fullName, passwordHash, role)
**Security:** Argon2PasswordEncoder
**Controller:** AuthController (/auth endpoint)

### Possíveis Causas
- [ ] Password hash incompatível (Argon2)
- [ ] Usuário não existe no banco MongoDB
- [ ] Problema na validação do AuthenticationUseCase
- [ ] Configuração de segurança Spring incorreta
- [ ] Problema de migração de dados (Mongock)
- [ ] CORS bloqueando requisições
- [ ] Problema de encoding de caracteres

### Validações de Sistema
**Verificar:**
- [ ] Teacher existe na coleção MongoDB
- [ ] Password hash está correto (Argon2)
- [ ] Role está definida corretamente
- [ ] Environment variables para senhas (se aplicável)
- [ ] SPRING_PROFILES_ACTIVE=dev para CORS
- [ ] Logs de aplicação para erros

## 🗂️ Dados de Migração

**Professores Padrão do Sistema:**
- **mrodriguez** - Sr. Rodriguez (TEACHER)
- **mchen** - Sra. Chen (TEACHER)  
- **principal** - Diretor Martinez (ADMIN)

**Senhas Padrão:** (configuráveis via environment)
- TEACHER_RODRIGUEZ_PASSWORD (padrão: art123)
- TEACHER_CHEN_PASSWORD (padrão: chess123)
- PRINCIPAL_PASSWORD (padrão: admin123)

## 🚨 Urgência e Impacto

**Nível de Urgência:**
- [ ] 🔴 Crítica - Não consegue trabalhar
- [ ] 🟠 Alta - Dificulta trabalho significativamente
- [ ] 🟡 Média - Inconveniente mas contornável
- [ ] 🟢 Baixa - Problema menor

**Impacto:**
- [ ] Apenas este professor
- [ ] Múltiplos professores
- [ ] Todo o sistema de autenticação
- [ ] Funcionalidades específicas após login

## 🛠️ Soluções Temporárias

### Se for Problema de Senha
**Reset de Senha Necessário:**
- [ ] Sim, resetar para padrão temporário
- [ ] Sim, definir nova senha específica
- [ ] Não aplicável

**Nova Senha Temporária:** (se necessário)
<!-- Senha temporária solicitada (será hasheada com Argon2) -->

### Se for Nova Conta
**Dados da Nova Conta:**
- **Username:** <!-- Nome único para login -->
- **Nome Completo:** <!-- Nome para exibição -->
- **Role:** 
  - [ ] TEACHER (professor regular)
  - [ ] ADMIN (administrador)

## 💡 Informações Adicionais

**Última Vez que Funcionou:**
<!-- Quando foi o último acesso bem-sucedido? -->

**Mudanças Recentes:**
<!-- Houve alterações no sistema, senhas, etc? -->

**Observações:**
<!-- Qualquer informação adicional relevante -->