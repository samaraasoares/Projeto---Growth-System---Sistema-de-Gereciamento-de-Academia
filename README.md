Growth System - Sistema de Gerenciamento de Academia
👥 Integrantes do Grupo
[Samara Fernandes Soares] - RA: [43480519]

[Mariana Moreira Barbosa ] - RA: [42880726]

[Igor da Silva Alves Correa] - RA: [41885163]

[Victoria Agatha Rodrigues Fagundes] - RA: [43756042]

📋 Tema Escolhido
Academia

Objetivo do Sistema
O sistema de gerenciamento de academia tem como objetivo centralizar o controle de alunos, instrutores e planos relacionados à saúde e exercícios. Foi projetado para facilitar a rotina administrativa, permitindo o cadastro de membros, acompanhamento de planos e organização de aulas coletivas, garantindo o respeito aos limites de capacidade.

Growth System - Gestão de Academia
O Growth System é um software desenvolvido em Java com persistência em banco de dados relacional PostgreSQL. O projeto aplica conceitos avançados de Orientação a Objetos e padrões de projeto para garantir escalabilidade e organização.

🏗️ Arquitetura do Projeto
O sistema segue o padrão DAO (Data Access Object), com uma estrutura de pacotes profissional:

br.com.GrowthSystem.model: Entidades que representam os dados do sistema (ex: Aluno, Instrutor, Aula).

br.com.GrowthSystem.dao: Camada de persistência que isola todo o código SQL e JDBC.

br.com.GrowthSystem.service: Camada de regras de negócio complexas, como a validação de lotação de turmas.

br.com.GrowthSystem.util: Utilitários de validação (ex: CPF) e definições de interfaces.

br.com.GrowthSystem.Main: Ponto de entrada que gerencia os menus e o fluxo do usuário.

🚀 Requisitos Técnicos Implementados
1. Orientação a Objetos Avançada
Abstração: A classe Pessoa é abstract, definindo o contrato para getTipo().

Herança: Aluno, Instrutor e Funcionario herdam de Pessoa.

Interfaces: Implementação das interfaces Auditavel e Financeiro (ou Calculavel) para definir comportamentos específicos de registo e cálculo.

Polimorfismo: Uso extensivo de @Override em métodos e interfaces.

2. Persistência de Dados (JDBC + PostgreSQL)
Segurança: Uso de PreparedStatement para prevenir SQL Injection.

Gestão de Recursos: Implementação de try-with-resources para fechamento automático de conexões.

CRUD Completo: Todas as entidades possuem operações de criação, leitura, atualização e exclusão.

3. Regra de Negócio Complexa
Validação de Inscrição: O sistema impede a matrícula de alunos em aulas que já atingiram a sua capacidade máxima, validando a lotação em tempo real através da camada de serviço.

Validação de CPF: Uso de utilitário para garantir a integridade dos dados de cadastro.

📺 Demonstração em Vídeo
Assista à demonstração do sistema em funcionamento, incluindo a execução das operações de CRUD e a validação das regras de negócio:

🎥 CLIQUE AQUI PARA VER O VÍDEO DE DEMONSTRAÇÃO

🛠️ Tecnologias Utilizadas
Linguagem: Java 17+

Banco de Dados: PostgreSQL 16

Driver JDBC: PostgreSQL JDBC Driver (42.7.10)

IDE: IntelliJ IDEA

🏁 Como Executar
Certifique-se de ter o PostgreSQL instalado e o banco growth_system criado.

Configure as credenciais de acesso em ConexaoBD.java.

Adicione o driver JDBC às dependências do projeto (Project Structure > Dependencies).

Execute a classe Main.java.

Desenvolvido como parte das atividades avaliativas de Banco de Dados e Programação.