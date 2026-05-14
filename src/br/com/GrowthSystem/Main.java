package br.com.GrowthSystem;

import br.com.GrowthSystem.model.*;
import br.com.GrowthSystem.dao.*;
import br.com.GrowthSystem.service.InscricaoService;
import br.com.GrowthSystem.util.ValidadorUtil;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final AlunoDAO alunoDAO = new AlunoDAO();
    private static final InstrutorDAO instrutorDAO = new InstrutorDAO();
    private static final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private static final AulaDAO aulaDAO = new AulaDAO();
    private static final InscricaoDAO inscricaoDAO = new InscricaoDAO();
    private static final InscricaoService service = new InscricaoService();

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GROWTH SYSTEM - MENU PRINCIPAL ===");
            System.out.println("1. Gerenciar Alunos");
            System.out.println("2. Gerenciar Instrutores");
            System.out.println("3. Gerenciar Funcionários");
            System.out.println("4. Gerenciar Aulas");
            System.out.println("5. Gerenciar Matrículas");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> menuAlunos();
                    case 2 -> menuInstrutores();
                    case 3 -> menuFuncionarios();
                    case 4 -> menuAulas();
                    case 5 -> menuInscricoes();
                    case 0 -> System.out.println("Encerrando o sistema...");
                    default -> System.out.println(" Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println(" Erro na entrada de dados.");
            }
        }
    }

    // --- MÉTODOS DE APOIO PARA VALIDAÇÃO ---
    private static String lerCpfValido() {
        while (true) {
            System.out.print("CPF (11 dígitos): ");
            String cpf = scanner.nextLine();
            if (ValidadorUtil.isCpfValido(cpf)) return cpf;
            System.out.println(" CPF inválido! Digite exatamente 11 números.");
        }
    }

    // --- SUBMENU ALUNOS ---
    private static void menuAlunos() {
        System.out.println("\n-- GESTÃO DE ALUNOS --");
        System.out.println("1. Cadastrar | 2. Listar | 3. Atualizar | 4. Excluir | 0. Voltar");
        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1 -> {
                System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Nome: "); String nome = scanner.nextLine();
                String cpf = lerCpfValido();
                alunoDAO.inserir(new Aluno(id, nome, cpf));
                System.out.println(" Aluno cadastrado!");
            }
            case 2 -> {
                System.out.println("\n--- LISTA DE ALUNOS ---");
                alunoDAO.listarTodos().forEach(al -> {
                    System.out.println(al);
                    System.out.println("   > Mensalidade: R$ " + al.calcularValor());
                    System.out.println("   > Último Log: " + (al.obterHistorico() != null ? al.obterHistorico() : "Sem registro"));
                });
            }
            case 3 -> {
                System.out.print("ID para atualizar: ");
                int id = Integer.parseInt(scanner.nextLine());
                Aluno al = alunoDAO.buscarPorId(id);
                if (al != null) {
                    System.out.print("Novo Nome: "); String nome = scanner.nextLine();
                    alunoDAO.atualizar(new Aluno(id, nome, al.getCpf()));
                    System.out.println(" Aluno atualizado!");
                } else {
                    System.out.println(" Aluno não encontrado.");
                }
            }
            case 4 -> {
                System.out.print("ID do Aluno para excluir: ");
                int id = Integer.parseInt(scanner.nextLine());
                alunoDAO.excluir(id);
                System.out.println(" Registro de aluno removido (se existia).");
            }
        }
    }

    // --- SUBMENU INSTRUTORES ---
    private static void menuInstrutores() {
        System.out.println("\n-- GESTÃO DE INSTRUTORES --");
        System.out.println("1. Cadastrar | 2. Listar | 3. Atualizar | 4. Excluir | 0. Voltar");
        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1 -> {
                System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Nome: "); String nome = scanner.nextLine();
                String cpf = lerCpfValido();
                System.out.print("Especialidade: "); String esp = scanner.nextLine();
                instrutorDAO.inserir(new Instrutor(id, nome, cpf, esp));
                System.out.println(" Instrutor cadastrado!");
            }
            case 2 -> {
                System.out.println("\n--- LISTA DE INSTRUTORES ---");
                instrutorDAO.listarTodos().forEach(ins -> {
                    System.out.println(ins);
                    System.out.println("   > Salário: R$ " + ins.calcularValor());
                    System.out.println("   > Registro Auditoria: " + (ins.obterHistorico() != null ? ins.obterHistorico() : "Nenhuma ação"));
                });
            }
            case 3 -> {
                System.out.print("ID para atualizar: ");
                int id = Integer.parseInt(scanner.nextLine());
                Instrutor ins = instrutorDAO.buscarPorId(id);
                if (ins != null) {
                    System.out.print("Novo Nome: "); String nome = scanner.nextLine();
                    System.out.print("Nova Especialidade: "); String esp = scanner.nextLine();
                    instrutorDAO.atualizar(new Instrutor(id, nome, ins.getCpf(), esp));
                    System.out.println(" Instrutor atualizado!");
                } else {
                    System.out.println(" Instrutor não encontrado.");
                }
            }
            case 4 -> {
                System.out.print("ID do Instrutor para excluir: ");
                int id = Integer.parseInt(scanner.nextLine());
                instrutorDAO.excluir(id);
                System.out.println(" Registro de instrutor removido.");
            }
        }
    }

    // --- SUBMENU FUNCIONÁRIOS ---
    private static void menuFuncionarios() {
        System.out.println("\n-- GESTÃO DE FUNCIONÁRIOS --");
        System.out.println("1. Cadastrar | 2. Listar | 3. Atualizar | 4. Excluir | 0. Voltar");
        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1 -> {
                System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Nome: "); String nome = scanner.nextLine();
                String cpf = lerCpfValido();
                System.out.print("Departamento: "); String dep = scanner.nextLine();
                funcionarioDAO.inserir(new Funcionario(id, nome, cpf, dep));
                System.out.println(" Funcionário cadastrado!");
            }
            case 2 -> funcionarioDAO.listarTodos().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID para atualizar: ");
                int id = Integer.parseInt(scanner.nextLine());
                Funcionario f = funcionarioDAO.buscarPorId(id);
                if (f != null) {
                    System.out.print("Novo Nome: "); String nome = scanner.nextLine();
                    System.out.print("Novo Departamento: "); String dep = scanner.nextLine();
                    funcionarioDAO.atualizar(new Funcionario(id, nome, f.getCpf(), dep));
                    System.out.println(" Funcionário atualizado!");
                } else {
                    System.out.println(" Funcionário não encontrado.");
                }
            }
            case 4 -> {
                System.out.print("ID do Funcionário para excluir: ");
                int id = Integer.parseInt(scanner.nextLine());
                funcionarioDAO.excluir(id);
                System.out.println(" Registro de funcionário removido.");
            }
        }
    }

    // --- SUBMENU AULAS ---
    private static void menuAulas() {
        System.out.println("\n-- GESTÃO DE AULAS --");
        System.out.println("1. Cadastrar | 2. Listar | 3. Atualizar | 4. Excluir | 0. Voltar");
        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1 -> {
                System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Modalidade: "); String mod = scanner.nextLine();
                System.out.print("Horário: "); String h = scanner.nextLine();
                System.out.print("Capacidade: "); int cap = Integer.parseInt(scanner.nextLine());
                aulaDAO.inserir(new Aula(id, mod, h, cap));
                System.out.println(" Aula cadastrada!");
            }
            case 2 -> aulaDAO.listarTodos().forEach(a ->
                    System.out.println("ID: " + a.getId() + " | " + a.getModalidade() + " | Vagas: " + a.getCapacidadeMax()));
            case 3 -> {
                System.out.print("ID para atualizar: ");
                int id = Integer.parseInt(scanner.nextLine());
                Aula au = aulaDAO.buscarPorId(id);
                if (au != null) {
                    System.out.print("Nova Modalidade: "); String mod = scanner.nextLine();
                    System.out.print("Novo Horário: "); String h = scanner.nextLine();
                    System.out.print("Nova Capacidade: "); int cap = Integer.parseInt(scanner.nextLine());
                    aulaDAO.atualizar(new Aula(id, mod, h, cap));
                    System.out.println(" Aula atualizada!");
                } else {
                    System.out.println(" Aula não encontrada.");
                }
            }
            case 4 -> {
                System.out.print("ID da Aula para excluir: ");
                int id = Integer.parseInt(scanner.nextLine());
                aulaDAO.excluir(id);
                System.out.println("✅ Aula removida do sistema.");
            }
        }
    }

    // --- SUBMENU MATRÍCULAS ---
    private static void menuInscricoes() {
        System.out.println("\n-- GESTÃO DE MATRÍCULAS --");
        System.out.println("1. Realizar Matrícula | 2. Listar | 3. Excluir | 0. Voltar");
        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1 -> {
                try {
                    System.out.print("ID Aluno: "); int idAl = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID Aula: "); int idAu = Integer.parseInt(scanner.nextLine());
                    Aluno al = alunoDAO.buscarPorId(idAl);
                    Aula au = aulaDAO.buscarPorId(idAu);
                    if (al != null && au != null) {
                        System.out.print("ID Inscrição: "); int id = Integer.parseInt(scanner.nextLine());
                        service.matricular(id, al, au);
                        System.out.println(" Matrícula e registro de auditoria concluídos!");
                    } else System.out.println(" Aluno ou Aula inexistente.");
                } catch (Exception e) { System.err.println(" Erro: " + e.getMessage()); }
            }
            case 2 -> inscricaoDAO.listarTodas().forEach(i ->
                    System.out.println("ID: " + i.getId() + " | Aluno: " + i.getAluno().getNome() + " | Aula: " + i.getAula().getModalidade()));
            case 3 -> {
                System.out.print("ID da Matrícula para excluir: ");
                int id = Integer.parseInt(scanner.nextLine());
                inscricaoDAO.excluir(id);
                System.out.println(" Matrícula cancelada/excluída.");
            }
        }
    }
}
