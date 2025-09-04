---
name: "📝 Modificar Atividade Existente"
about: "Solicitar alterações em uma atividade extracurricular já existente"
title: "[MODIFICAR ATIVIDADE] "
labels: ["enhancement", "modificar-atividade", "professor-request"]
assignees: ["@copilot"]
---

## 🎯 Atividade a Ser Modificada

**Nome da Atividade Atual:**
<!-- Nome exato da atividade no sistema. Atividades disponíveis:
- Clube de Xadrez
- Aula de Programação  
- Fitness Matinal
- Time de Futebol
- Time de Basquete
- Clube de Arte
- Clube de Teatro
- Clube de Matemática
- Equipe de Debates
- Oficina de Robótica
- Olimpíada de Ciências
- Torneio de Xadrez
- Serviço Comunitário
-->

## 🔄 Alterações Solicitadas

### Informações Básicas
**Nova Descrição:** (deixe em branco se não alterar)
<!-- Nova descrição da atividade -->

**Novo Tipo de Atividade:** (marque apenas se alterar)
- [ ] 🏃 Esportes
- [ ] 🎨 Artes  
- [ ] 📚 Acadêmico
- [ ] 🤝 Comunidade
- [ ] 💻 Tecnologia

### Cronograma
**Alterar Horário:**
- [ ] Sim, alterar horário
  - **Novo Horário de Início:** _:_ (formato HH:MM)
  - **Novo Horário de Término:** _:_ (formato HH:MM)

**Alterar Dias da Semana:**
- [ ] Sim, alterar dias
  - [ ] Segunda-feira
  - [ ] Terça-feira
  - [ ] Quarta-feira
  - [ ] Quinta-feira
  - [ ] Sexta-feira
  - [ ] Sábado
  - [ ] Domingo

### Capacidade
**Alterar Capacidade Máxima:**
- [ ] Sim, alterar capacidade
  - **Nova Capacidade:** <!-- Número de participantes -->

### Gerenciamento de Participantes
**Ações com Participantes:**
- [ ] Remover participante específico
  - **Email do participante:** <!-- email@mergington.edu -->
- [ ] Remover todos os participantes
- [ ] Adicionar participante específico
  - **Email do participante:** <!-- email@mergington.edu -->

## ✅ Critérios de Aceitação

- [ ] Atividade identificada corretamente no banco de dados
- [ ] Alterações aplicadas conforme solicitado
- [ ] Validações de domínio respeitadas
- [ ] ScheduleDetails atualizado se cronograma alterado
- [ ] Lista de participantes modificada conforme solicitado
- [ ] Capacidade validada (deve ser >= número atual de participantes)
- [ ] Tipo de atividade atualizado se solicitado
- [ ] Interface web reflete as mudanças
- [ ] Histórico de alterações mantido (se aplicável)

## 🔧 Contexto Técnico

**Use Case:** ActivityUseCase para atualização
**Validações Necessárias:**
- Nome da atividade deve existir
- Nova capacidade >= participantes atuais
- Horários válidos (início < término)
- Emails de participantes válidos
- Dias da semana em formato correto

**Padrões a Seguir:**
- Usar métodos de atualização da entidade Activity
- Manter validações de construtor/setters
- Resposta HTTP 404 se atividade não encontrada
- Resposta HTTP 400 para dados inválidos

## 🚨 Considerações Importantes

**Impacto nos Participantes:**
- Alterar horário pode afetar participantes já inscritos
- Reduzir capacidade pode exigir remoção de participantes
- Mudança de tipo pode afetar categorização

**Dados Relacionados:**
- Verificar se mudanças afetam outras funcionalidades
- Manter integridade referencial
- Considerar notificações aos participantes (futuro)

## 💡 Justificativa da Mudança

**Motivo da Alteração:**
<!-- Explique por que esta mudança é necessária -->

**Impacto Esperado:**
<!-- Como esta mudança beneficiará estudantes/escola -->

**Urgência:**
- [ ] Alta - Implementar urgentemente
- [ ] Média - Implementar em breve
- [ ] Baixa - Implementar quando possível