-- 1. Tabela para a classe Aluno
CREATE TABLE aluno (
    codigo INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    status_plano VARCHAR(20) DEFAULT 'Ativo'
);

-- 2. Tabela para a classe Instrutor
CREATE TABLE instrutor (
    codigo INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    especialidade VARCHAR(50) NOT NULL
);

-- 3. Tabela para a classe Funcionario
CREATE TABLE funcionario (
    codigo INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    departamento VARCHAR(50) NOT NULL
);

-- 4. Tabela para a classe Aula
CREATE TABLE aula (
    codigo INT PRIMARY KEY,
    modalidade VARCHAR(50) NOT NULL,
    horario VARCHAR(5) NOT NULL, -- Formato HH:mm
    capacidade_max INT NOT NULL
);
-- 5. Tabela para a classe Inscrição
CREATE TABLE inscricao (
    codigo INT PRIMARY KEY,
    aluno_codigo INT NOT NULL,
    aula_codigo INT NOT NULL,
    data_inscricao VARCHAR(10) NOT NULL, -- Formato DD/MM/AAAA

    CONSTRAINT fk_aluno FOREIGN KEY (aluno_codigo) REFERENCES aluno(codigo) ON DELETE CASCADE,
    CONSTRAINT fk_aula FOREIGN KEY (aula_codigo) REFERENCES aula(codigo) ON DELETE CASCADE
);

-- Comentários de auxílio:
-- O campo 'codigo' em todas as tabelas corresponde ao atributo 'id' no Java.
-- O campo 'cpf' possui a restrição UNIQUE para garantir que não existam duplicatas no sistema.
-- A regra 'ON DELETE CASCADE' na tabela de inscrição garante que, se um aluno ou aula for excluído, 
-- o registro de matrícula dele também seja removido automaticamente para evitar erros de referência.