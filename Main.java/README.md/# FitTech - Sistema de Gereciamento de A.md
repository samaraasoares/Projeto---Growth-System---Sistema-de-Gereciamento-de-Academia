# Growth System - Sistema de Gereciamento de Academia

# 👥 Integrantes do Grupo
- [Samara Fernandes Soares] - RA: [43480519]
- [Mariana ] - RA: []
- [Igor ] - RA: [41885163]
- [Vitoria ] - RA: []


## 📋Tema Escolhido
Academia

## Objetivo do Sistema
O sistema de gerenciamento de Academia, tem o objetivo de centralizar o controle de alunos, instrutores e planos que seria saúde e exercicios.
Ele foi projetado para facilitar a rotina adiministrativa de uma recepcao de academia, permitindo o cadastro de novos menbros, e acompanhar quais
os planos ativos.

Além disso, o sistema foca na organização de aulas coletivas, para garantir que o limite de capacidade das salas seja respeitado, e que não haja
conflitos de horários para os alunos.

## Funcionalidades Principais
1.  **Gerenciamento de alunos:**
Cadastro, atualização e exclusão de dados do cliente.
2.  **Controle de Planos:**
Gestão de mensalidades e verificação de vencimentos.
3. **Gestão de Instrutores:**
Cadastro dos profissionais responsáveis pelas aulas.
4. **Agendamento de Aulas:**
Controle de vagas e horários de aulas coletivas.
5. **Registro de Frequência:**
Histórico de presenca dos alunos na academia.

## Estrutura de Classes
- **Aluno:** Responsável por armazenar dados pessoais e status do plano do cliente.
- **Instrutor** Armazena dados profissionais e suas especialidades.
- **Plano** Define os valores, duração e benefícios de cada tipo der adesão.
- **Aula** Gerencia a modalidade, horários, instrutor  e lista de presença.
- **Inscricao** Classe intermediária que vai validar se o aluno pode ou não entrar na aula.

## Regra de Negócio Complexa
A regra de negócio principal é a **Validação de Inscrição**. Quando for matricular um aluno em uma aula, o sistema executa uma tripla verifição:
primeiro vai checa se o plano do aluno não está vencido (calculado pela data de início + duração); depois vai verificar se a sala de aula coletiva ainda
posui vagas, e por fim vai garantir que o aluno não outra aula marcada no mesmo horário.
