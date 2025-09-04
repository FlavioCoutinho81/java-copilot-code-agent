---
name: "🕐 Alteração de Cronograma/Horário"
about: "Solicitar mudanças nos cronogramas e horários das atividades existentes"
title: "[CRONOGRAMA] "
labels: ["enhancement", "cronograma", "professor-request"]
assignees: ["@copilot"]
---

## 📅 Solicitação de Alteração de Cronograma

### Atividade(s) Afetada(s)
**Nome da Atividade:**
<!-- Nome exato da atividade. Para múltiplas atividades, liste todas -->

**Cronograma Atual:**
<!-- Ex: Segunda e Sexta, 15:15 - 16:45 -->

## 🔄 Mudanças Solicitadas

### Tipo de Alteração
- [ ] 📆 Alterar dias da semana
- [ ] ⏰ Alterar horários (início/fim)
- [ ] 📅➕⏰ Alterar dias e horários
- [ ] 🚫 Cancelar atividade em data específica
- [ ] 📄 Alteração temporária (período específico)
- [ ] 📄 Alteração permanente

### Novo Cronograma

**Novos Dias da Semana:**
- [ ] Segunda-feira
- [ ] Terça-feira
- [ ] Quarta-feira
- [ ] Quinta-feira
- [ ] Sexta-feira
- [ ] Sábado
- [ ] Domingo

**Novos Horários:**
- **Início:** __:__ (formato HH:MM)
- **Término:** __:__ (formato HH:MM)

### Período da Alteração (se temporária)
**Data de Início:** ___/___/_______ (DD/MM/AAAA)
**Data de Término:** ___/___/_______ (DD/MM/AAAA)

## 🎯 Justificativa da Mudança

**Motivo da Alteração:**
- [ ] Conflito com outra atividade
- [ ] Disponibilidade do professor
- [ ] Solicitação dos estudantes
- [ ] Mudança na disponibilidade de espaço/equipamento
- [ ] Otimização de cronograma
- [ ] Evento especial
- [ ] Outro: <!-- Especificar -->

**Detalhamento:**
<!-- Explique a necessidade específica da mudança -->

## 👥 Impacto nos Participantes

**Participantes Atuais:**
<!-- Quantos estudantes serão afetados? -->

**Notificação Necessária:**
- [ ] Sim, estudantes precisam ser avisados
- [ ] Não, mudança não afeta participantes

**Conflitos Potenciais:**
<!-- A mudança pode gerar conflitos com outras atividades dos estudantes? -->

## ✅ Critérios de Aceitação

- [ ] ScheduleDetails da atividade atualizado no banco de dados
- [ ] Campos `schedule` (texto) e `scheduleDetails` (objeto) sincronizados  
- [ ] Validação de horários aplicada (início < término)
- [ ] Validação de dias da semana (formato inglês: Monday, Tuesday, etc.)
- [ ] Interface web exibe novo cronograma corretamente
- [ ] Histórico de mudanças registrado (se aplicável)
- [ ] Participantes mantidos após alteração
- [ ] Sem conflitos com restrições de capacidade

## 🔧 Contexto Técnico

**Componentes Afetados:**
- **Entity:** Activity.scheduleDetails (ScheduleDetails value object)
- **Value Object:** ScheduleDetails (days, startTime, endTime)
- **Use Case:** ActivityUseCase para atualização
- **Repository:** ActivityRepository.update()

**Validações Técnicas:**
- LocalTime.of() para horários válidos
- Lista de dias em formato correto (inglês)
- Início antes do término
- Dias da semana válidos

**Formato Esperado:**
- Dias: ["Monday", "Wednesday", "Friday"]
- Horários: LocalTime.of(15, 30) // 15:30

## 🚨 Considerações Importantes

### Dependências
**Recursos Necessários:**
- [ ] Sala/espaço específico
- [ ] Equipamentos especiais
- [ ] Disponibilidade de outros professores

### Restrições
**Limitações Conhecidas:**
- Horários de funcionamento da escola: ___:___ às ___:___
- Conflitos com outras atividades fixas
- Disponibilidade de transporte escolar
- Regulamentações específicas

## 📋 Validação Prévia

**Confirmações Necessárias:**
- [ ] Novo horário não conflita com outras atividades
- [ ] Professor responsável disponível no novo horário
- [ ] Espaço/equipamento disponível
- [ ] Participantes podem atender ao novo cronograma
- [ ] Mudança aprovada pela administração (se necessário)

## 💡 Informações Complementares

**Observações Especiais:**
<!-- Qualquer informação adicional relevante -->

**Urgência:**
- [ ] Implementar imediatamente
- [ ] Implementar até: ___/___/_______
- [ ] Flexível, implementar quando possível

**Professor Solicitante:**
<!-- Nome de usuário: mrodriguez, mchen, principal -->