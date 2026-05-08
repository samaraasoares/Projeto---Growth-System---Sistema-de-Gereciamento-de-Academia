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

# Growth System - Gestão de Academia

O **Growth System** é um software de gestão de academia desenvolvido em Java com persistência em banco de dados relacional PostgreSQL. O projeto aplica conceitos avançados de Orientação a Objetos e padrões de projeto para garantir escalabilidade, segurança e organização.

## 🏗️ Arquitetura do Projeto

O sistema segue o padrão **DAO (Data Access Object)**, separando as responsabilidades em pacotes específicos:

- **`model/`**: Classes de domínio (entidades) que representam os dados do sistema.
- **`dao/`**: Camada de persistência que isola todo o código SQL e JDBC.
- **`util/`**: Utilitários para validações de regras de negócio (ex: validação de CPF).
- **`Main.java`**: Ponto de entrada que gerencia os menus e o fluxo do usuário.

## 🚀 Requisitos Técnicos Implementados

### 1. Orientação a Objetos Avançada
- **Abstração**: A classe `Pessoa` é definida como `abstract`, contendo o método abstrato `getTipo()`, obrigando as classes filhas a implementarem sua própria identificação.
- **Herança**: `Aluno`, `Instrutor` e `Funcionario` herdam atributos comuns de `Pessoa` via modificador `protected`.
- **Polimorfismo**: Uso de sobrescrita de métodos (`@Override`) para representação textual e lógica de tipos.

### 2. Persistência de Dados (JDBC + PostgreSQL)
- **Segurança**: Uso rigoroso de `PreparedStatement` em todas as consultas para prevenir ataques de *SQL Injection*.
- **Gestão de Recursos**: Implementação de `try-with-resources` para garantir o fechamento automático de conexões e evitar vazamentos de memória.
- **CRUD Completo**: Todas as entidades principais possuem operações de Inserção, Consulta, Atualização e Exclusão.

### 3. Funcionalidades de Negócio
- Cadastro e gestão de Alunos, Instrutores e Funcionários.
- Gerenciamento de Aulas (modalidades, horários e capacidades).
- Matrícula de Alunos em Aulas específicas com validação de chaves estrangeiras.

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java 17+
- **Banco de Dados**: PostgreSQL 16
- **Driver JDBC**: PostgreSQL JDBC Driver (42.x.x)
- **IDE**: IntelliJ IDEA

## 🗄️ Estrutura do Banco de Dados

O banco de dados `growth_system` deve ser criado com as seguintes tabelas principais:
- `aluno`
- `instrutor`
- `funcionario`
- `aula`
- `inscricao` (Tabela de ligação com FKs para Aluno e Aula)

## 🏁 Como Executar

1. Certifique-se de ter o **PostgreSQL** instalado e o banco `growth_system` criado.
2. Execute o script SQL fornecido na documentação do projeto no seu pgAdmin.
3. Configure as credenciais de acesso no arquivo `src/dao/ConexaoBD.java`.
4. Adicione o driver JDBC do PostgreSQL às dependências do seu projeto no IntelliJ (*Project Structure > Modules > Dependencies*).
5. Execute a classe `Main.java`.

---
*Desenvolvido como parte das atividades avaliativas de Banco de Dados e Programação.*
