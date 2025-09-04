---
name: "🎯 Nova Atividade Extracurricular"
about: "Solicitar criação de uma nova atividade extracurricular no sistema"
title: "[NOVA ATIVIDADE] "
labels: ["enhancement", "nova-atividade", "professor-request"]
assignees: ["@copilot"]
---

## 📋 Informações da Nova Atividade

### Dados Básicos
**Nome da Atividade:**
<!-- Ex: Clube de Fotografia, Time de Vôlei, Laboratório de Química -->

**Descrição Detalhada:**
<!-- Descreva objetivos, metodologia e benefícios da atividade para os estudantes -->

**Tipo de Atividade:**
- [ ] 🏃 Esportes (atividades físicas, equipes esportivas)
- [ ] 🎨 Artes (música, teatro, pintura, criação)
- [ ] 📚 Acadêmico (clubes de estudo, competições educacionais)
- [ ] 🤝 Comunidade (voluntariado, projetos sociais)
- [ ] 💻 Tecnologia (programação, robótica, informática)

### Cronograma e Logística

**Dias da Semana:**
- [ ] Segunda-feira
- [ ] Terça-feira
- [ ] Quarta-feira
- [ ] Quinta-feira
- [ ] Sexta-feira
- [ ] Sábado
- [ ] Domingo

**Horário:**
- **Início:** _:_ (formato HH:MM)
- **Término:** _:_ (formato HH:MM)

**Capacidade Máxima de Participantes:**
<!-- Número máximo de estudantes que podem participar -->

### Professor Responsável
**Nome do Usuário:** <!-- Ex: mrodriguez, mchen, principal -->
**Nome Completo:** <!-- Ex: Sr. Rodriguez, Sra. Chen -->

---

## ✅ Critérios de Aceitação

- [ ] Atividade criada no banco de dados MongoDB
- [ ] Tipo de atividade classificado automaticamente baseado no nome/descrição
- [ ] Cronograma configurado corretamente com dias e horários
- [ ] Capacidade máxima definida
- [ ] Lista de participantes inicializada vazia
- [ ] Validações de domínio aplicadas (nome obrigatório, capacidade > 0)
- [ ] Atividade aparece na interface web para professores e estudantes
- [ ] Possível registro de estudantes na nova atividade

## 🔧 Contexto Técnico

**Arquitetura:** Clean Architecture Spring Boot
**Camadas Afetadas:**
- Domain: Criação da entidade Activity
- Application: Use case para criar atividade
- Infrastructure: Persistência MongoDB
- Presentation: Endpoint REST (se necessário)

**Padrões a Seguir:**
- Validação de entidade no construtor
- Uso do enum ActivityType para classificação
- ScheduleDetails como value object para cronograma
- Resposta HTTP consistente em caso de erro

## 🚨 Restrições e Limitações

- Não criar atividades com nomes duplicados
- Horários devem ser válidos (início < término)
- Capacidade deve ser número positivo
- Dias da semana devem seguir formato em inglês (Monday, Tuesday, etc.)
- Seguir padrão de migração Mongock se necessário para dados iniciais

## 💡 Informações Adicionais

**Prioridade:** <!-- Alta, Média, Baixa -->
**Data Desejada de Implementação:** <!-- DD/MM/AAAA -->
**Observações Especiais:**
<!-- Qualquer informação adicional relevante -->