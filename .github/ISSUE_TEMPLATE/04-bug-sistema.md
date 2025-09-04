---
name: "🐛 Problema Técnico / Bug do Sistema"
about: "Reportar problemas técnicos, erros ou comportamentos inesperados no sistema"
title: "[BUG] "
labels: ["bug", "sistema-tecnico", "professor-request"]
assignees: ["@copilot"]
---

## 🚨 Resumo do Problema

**Descrição Breve:**
<!-- Descreva o problema em uma frase -->

**Área do Sistema Afetada:**
- [ ] 🔐 Autenticação/Login
- [ ] 📋 Listagem de Atividades
- [ ] ➕ Criação de Atividades
- [ ] ✏️ Edição de Atividades
- [ ] 👥 Gerenciamento de Estudantes
- [ ] 🕐 Cronogramas/Horários
- [ ] 🌐 Interface Web (Frontend)
- [ ] 📊 Dados/Relatórios
- [ ] 🔄 Outro (especificar)

## 🔍 Detalhes Técnicos

### Informações do Erro
**Mensagem de Erro Exibida:**
```
Cole aqui a mensagem de erro exata, se houver
```

**Código de Status HTTP:** (se aplicável)
<!-- Ex: 500, 404, 400, 401 -->

**URL/Endpoint Afetado:**
<!-- Ex: /activities, /auth/login, etc. -->

### Reprodução do Problema
**Passos para Reproduzir:**
1. <!-- Ação específica -->
2. <!-- Próximo passo -->
3. <!-- Resultado observado -->

**Dados de Teste Usados:**
<!-- Informações usadas durante o teste (sem senhas!) -->

**Resultado Atual:**
<!-- O que está acontecendo -->

**Resultado Esperado:**
<!-- O que deveria acontecer -->

## 🖥️ Ambiente e Contexto

**Navegador:** (se problema de interface)
<!-- Chrome, Firefox, Safari, Edge + versão -->

**Sistema Operacional:**
<!-- Windows, Mac, Linux -->

**Horário do Incidente:**
<!-- Data e hora quando o problema ocorreu -->

**Frequência:**
- [ ] Sempre acontece
- [ ] Às vezes acontece
- [ ] Aconteceu apenas uma vez
- [ ] Começou recentemente

## 📱 Screenshots/Evidências

**Capturas de Tela:**
<!-- Anexe imagens se possível -->

**Logs Relevantes:** (se disponível)
```
Cole aqui logs de console ou servidor
```

## ✅ Critérios de Aceitação para Correção

- [ ] Problema reproduzido em ambiente de desenvolvimento
- [ ] Causa raiz identificada
- [ ] Correção implementada na camada apropriada (Domain/Application/Infrastructure/Presentation)
- [ ] Validações adequadas implementadas
- [ ] Response HTTP correto retornado
- [ ] Tratamento de erro adequado
- [ ] Logs informativos adicionados (se necessário)
- [ ] Teste automatizado criado para evitar regressão
- [ ] Sistema funciona conforme esperado após correção

## 🔧 Contexto Técnico para Debugging

**Arquitetura Clean - Possíveis Camadas Afetadas:**
- [ ] **Domain:** Entidades, Value Objects, Validações
- [ ] **Application:** Use Cases, DTOs, Orquestração
- [ ] **Infrastructure:** Banco MongoDB, Configurações, Mongock
- [ ] **Presentation:** Controllers REST, Mapeamento de DTOs

**Tecnologias Envolvidas:**
- Spring Boot 3.5.4
- MongoDB + Spring Data
- Argon2 (autenticação)
- Mongock (migrações)

**Padrões de Resposta Esperados:**
- `200` para sucesso
- `400` para erro de validação com `{"detail": "mensagem"}`
- `401` para falha de autenticação
- `404` para recurso não encontrado

## 🚨 Impacto e Prioridade

**Gravidade:**
- [ ] 🔴 Crítica - Sistema completamente inutilizável
- [ ] 🟠 Alta - Funcionalidade principal quebrada
- [ ] 🟡 Média - Funcionalidade secundária afetada
- [ ] 🟢 Baixa - Problema cosmético ou menor

**Usuários Afetados:**
- [ ] Todos os professores
- [ ] Professor específico: <!-- username -->
- [ ] Todos os estudantes
- [ ] Funcionalidade específica apenas

**Urgência:**
- [ ] Imediata - Precisa ser corrigido hoje
- [ ] Alta - Precisa ser corrigido esta semana
- [ ] Normal - Pode aguardar próxima versão
- [ ] Baixa - Quando houver tempo

## 💡 Informações Adicionais

**Mudanças Recentes:**
<!-- Houve alguma mudança no sistema recentemente? -->

**Soluções Tentadas:**
<!-- O que já foi tentado para resolver? -->

**Observações:**
<!-- Qualquer outra informação relevante -->