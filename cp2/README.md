# Growth System - Sistema de Gereciamento de Academia

# 👥 Integrantes do Grupo
- [Samara Fernandes Soares] - RA: [43480519]
- [Mariana Moreira Barbosa ] - RA: [42880726]
- [Igor da Silva Alves Correa] - RA: [41885163]
- [Victoria Agatha Rodrigues Fagundes] - RA: [43756042]


## 📋Tema Escolhido
Academia

## Objetivo do Sistema
O sistema de gerenciamento de academia tem como objetivo centralizar o controle de alunos, instrutores e planos relacionados à saúde e exercícios.

Ele foi projetado para facilitar a rotina administrativa de uma recepção de academia, permitindo o cadastro de novos membros e o acompanhamento dos planos ativos.

Além disso, o sistema organiza aulas coletivas, garantindo que o limite de capacidade seja respeitado e evitando conflitos de horários entre os alunos.

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

## Hierarquia de Classes

O sistema utiliza herança para organizar entidades que compartilham características em comum:

- **Pessoa (superclasse)**
Contém atributos e métodos comuns, como id e nome.

- **Aluno (subclasse)**
Possui CPF e status do plano.

- **Instrutor (subclasse)**
Possui especialidade profissional.

## Outras Classes do Sistema

**Plano:** Define valores e duração dos planos.
**Aula:** Gerencia modalidade, horário e capacidade.
**Inscricao:** Relaciona alunos com aulas.


## Regra de Negócio Complexa
A regra de negócio principal é a **Validação de Inscrição**. Quando for matricular um aluno em uma aula, o sistema executa uma tripla verifição:
primeiro vai checa se o plano do aluno não está vencido (calculado pela data de início + duração); depois vai verificar se a sala de aula coletiva ainda
posui vagas, e por fim vai garantir que o aluno não outra aula marcada no mesmo horário.
