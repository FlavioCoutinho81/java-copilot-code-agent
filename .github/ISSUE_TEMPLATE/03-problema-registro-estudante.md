---
name: "👥 Problemas com Registro de Estudantes"
about: "Reportar problemas relacionados ao registro/inscrição de estudantes em atividades"
title: "[REGISTRO ESTUDANTE] "
labels: ["bug", "estudante-registro", "professor-request"]
assignees: ["@copilot"]
---

## 🎯 Identificação do Problema

**Tipo de Problema:**
- [ ] Estudante não consegue se inscrever em atividade
- [ ] Estudante inscrito não aparece na lista
- [ ] Inscrição duplicada do mesmo estudante  
- [ ] Erro ao tentar remover estudante
- [ ] Atividade aparece lotada quando não deveria
- [ ] Estudante inscrito em atividade inexistente
- [ ] Outros problemas de registro

## 📋 Detalhes do Incidente

### Informações do Estudante
**Email do Estudante:**
<!-- Ex: michael@mergington.edu, emma@mergington.edu -->

**Nome do Estudante:** (se conhecido)
<!-- Nome completo do estudante -->

### Informações da Atividade
**Nome da Atividade:**
<!-- Atividade envolvida no problema -->

**Situação Atual da Atividade:**
- **Capacidade Máxima:** <!-- Se conhecido -->
- **Participantes Atuais:** <!-- Número atual se conhecido -->

## 🔍 Descrição Detalhada do Problema

**O que aconteceu:**
<!-- Descreva exatamente o que ocorreu -->

**O que era esperado:**
<!-- Descreva o comportamento esperado -->

**Quando ocorreu:**
<!-- Data e horário aproximado -->

**Como reproduzir:**
1. <!-- Passo 1 -->
2. <!-- Passo 2 -->
3. <!-- Passo 3 -->

## 🖥️ Evidências Técnicas

**Mensagens de Erro:** (se aplicável)
```
Cole aqui qualquer mensagem de erro exibida
```

**Screenshots/Prints:** (se aplicável)
<!-- Anexe capturas de tela se possível -->

**URL onde ocorreu o problema:**
<!-- Ex: http://localhost:8080/activities -->

## ✅ Critérios de Aceitação para Correção

- [ ] Problema reproduzido e identificado
- [ ] Causa raiz determinada (validação, lógica de negócio, etc.)
- [ ] Correção implementada na camada apropriada
- [ ] Validações de domínio funcionando corretamente
- [ ] StudentRegistrationUseCase operando conforme esperado
- [ ] Interface web refletindo dados corretos
- [ ] Testes implementados para evitar regressão
- [ ] Problema não ocorre mais nas mesmas condições

## 🔧 Contexto Técnico para Investigação

**Componentes Envolvidos:**
- **Use Case:** StudentRegistrationUseCase
- **Entity:** Activity (método addParticipant, removeParticipant)
- **Repository:** ActivityRepository
- **Controller:** Activity-related endpoints

**Possíveis Causas:**
- Validação de email incorreta (Email value object)
- Lógica de capacidade máxima (canAddParticipant)
- Concorrência em operações simultâneas
- Inconsistência entre banco e aplicação
- Problema na validação de duplicatas

**Pontos de Verificação:**
- Logs de aplicação para erros
- Estado do banco MongoDB
- Validações na entidade Activity
- Response HTTP adequado (400, 404, 409)

## 🚨 Impacto e Urgência

**Impacto:**
- [ ] Alto - Afeta múltiplos estudantes/atividades
- [ ] Médio - Afeta estudante específico
- [ ] Baixo - Problema cosmético ou menor

**Urgência:**
- [ ] Crítica - Sistema inutilizável
- [ ] Alta - Necessita correção rápida
- [ ] Média - Correção em próxima versão
- [ ] Baixa - Correção quando conveniente

**Estudantes Afetados:**
<!-- Número estimado de estudantes impactados -->

## 💡 Informações Adicionais

**Contexto Escolar:**
<!-- Há prazo para inscrições? Evento especial? -->

**Soluções Temporárias Tentadas:**
<!-- O que já foi tentado para resolver? -->

**Observações do Professor:**
<!-- Qualquer informação adicional relevante -->