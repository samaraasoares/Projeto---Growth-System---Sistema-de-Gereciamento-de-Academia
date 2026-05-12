# Growth System - Sistema de Gerenciamento de Academia

# 👥 Integrantes do Grupo
- [Samara Fernandes Soares] - RA: [43480519]
- [Mariana Moreira Barbosa] - RA: [42880726]
- [Igor da Silva Alves Correa] - RA: [41885163]
- [Victoria Agatha Rodrigues Fagundes] - RA: [43756042]

## 📋 Tema Escolhido
Academia

## Objetivo do Sistema
O sistema de gerenciamento de academia tem como objetivo centralizar o controle de alunos, instrutores e planos relacionados à saúde e exercícios. Projetado para facilitar a rotina administrativa, permite o cadastro de membros e o acompanhamento de aulas coletivas, garantindo o respeito aos limites de capacidade e evitando conflitos de horários.

# Growth System - Gestão de Academia

O **Growth System** é um software de gestão desenvolvido em Java com persistência em banco de dados relacional PostgreSQL. O projeto aplica conceitos avançados de Orientação a Objetos e padrões de projeto para garantir escalabilidade e organização.

## 🏗️ Arquitetura do Projeto

O sistema segue o padrão **DAO (Data Access Object)** e uma estrutura de pacotes profissional para separação de responsabilidades:

- **`br.com.GrowthSystem.model`**: Entidades de domínio que representam os dados (ex: Aluno, Aula).
- **`br.com.GrowthSystem.dao`**: Camada de persistência que isola o código SQL e JDBC.
- **`br.com.GrowthSystem.service`**: Camada de regras de negócio complexas e validações.
- **`br.com.GrowthSystem.util`**: Utilitários para validações e definições de interfaces de comportamento.
- **`br.com.GrowthSystem.Main`**: Ponto de entrada que gerencia os menus e o fluxo do usuário.

## 🚀 Requisitos Técnicos Implementados

### 1. Orientação a Objetos Avançada
- **Abstração**: Classe `Pessoa` definida como `abstract`, contendo o método `getTipo()`.
- **Herança**: `Aluno`, `Instrutor` e `Funcionario` herdam de `Pessoa`.
- **Interfaces**: Implementação das interfaces `Auditavel` e `Financeiro` para definir contratos de comportamento.
- **Polimorfismo**: Uso de sobrescrita de métodos (`@Override`) para representação e lógica específica.

### 2. Persistência de Dados (JDBC + PostgreSQL)
- **Segurança**: Uso de `PreparedStatement` para prevenir ataques de *SQL Injection*.
- **Gestão de Recursos**: Implementação de `try-with-resources` para fechamento automático de conexões.
- **CRUD Completo**: Operações de Inserção, Consulta, Atualização e Exclusão para as entidades principais.

### 3. Regra de Negócio Complexa
- **Validação de Inscrição**: O sistema impede a matrícula de alunos em aulas que já atingiram a sua capacidade máxima, realizando a validação em tempo real na camada de serviço.
- **Validação de Dados**: Uso de `ValidadorUtil` para assegurar a integridade de informações como o CPF no momento do cadastro.

## 📺 Demonstração em Vídeo

Assista à demonstração prática das funcionalidades do sistema, incluindo o funcionamento do CRUD e as validações de regras de negócio:

[🎥 CLIQUE AQUI PARA VER O VÍDEO DE DEMONSTRAÇÃO](LINK_DO_SEU_VIDEO_AQUI)

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java 17+
- **Banco de Dados**: PostgreSQL 16
- **Driver JDBC**: PostgreSQL JDBC Driver (42.7.10)
- **IDE**: IntelliJ IDEA

## 🏁 Como Executar

1. Certifique-se de ter o **PostgreSQL** instalado e o banco `growth_system` criado.
2. Configure as credenciais de acesso no arquivo `ConexaoBD.java`.
3. Adicione o driver JDBC às dependências do projeto
