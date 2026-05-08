import model.*;
import dao.*;
import util.ValidadorUtil;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AlunoDAO alunoDAO = new AlunoDAO();
    private static final InstrutorDAO instrutorDAO = new InstrutorDAO();
    private static final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private static final AulaDAO aulaDAO = new AulaDAO();
    private static final InscricaoDAO inscricaoDAO = new InscricaoDAO();

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GROWTH SYSTEM - GESTÃO COMPLETA ===");
            System.out.println("1. Alunos | 2. Instrutores | 3. Funcionários");
            System.out.println("4. Aulas  | 5. Matricular Aluno | 0. Sair");
            System.out.print("Escolha: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> menuAlunos();
                    case 2 -> menuInstrutores();
                    case 3 -> menuFuncionarios();
                    case 4 -> menuAulas();
                    case 5 -> realizarInscricao();
                    case 0 -> System.out.println("Encerrando...");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void menuAlunos() {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- GESTÃO DE ALUNOS ---");
            System.out.println("1. Cadastrar | 2. Listar | 3. Atualizar | 4. Excluir | 0. Voltar");
            System.out.print("Escolha: ");
            try {
                op = Integer.parseInt(scanner.nextLine());

                if (op == 1) {
                    // OPERAÇÃO: CREATE
                    System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome: "); String nome = scanner.nextLine();
                    System.out.print("CPF (apenas números): "); String cpf = scanner.nextLine();

                    if (ValidadorUtil.isCpfValido(cpf)) {
                        alunoDAO.inserir(new Aluno(id, nome, cpf));
                    } else {
                        System.out.println("❌ CPF Inválido.");
                    }

                } else if (op == 2) {
                    // OPERAÇÃO: READ
                    System.out.println("\nLista de Alunos Cadastrados:");
                    alunoDAO.listarTodos().forEach(System.out::println);

                } else if (op == 3) {
                    // OPERAÇÃO: UPDATE
                    System.out.print("Digite o ID do Aluno que deseja atualizar: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    // Verificamos se o aluno existe antes de pedir os novos dados
                    Aluno alunoExistente = alunoDAO.buscarPorId(id);
                    if (alunoExistente != null) {
                        System.out.print("Novo Nome: "); String nome = scanner.nextLine();
                        System.out.print("Novo CPF: "); String cpf = scanner.nextLine();

                        if (ValidadorUtil.isCpfValido(cpf)) {
                            alunoDAO.atualizar(new Aluno(id, nome, cpf));
                        } else {
                            System.out.println("Novo CPF é inválido. Operação cancelada.");
                        }
                    } else {
                        System.out.println("Aluno com ID " + id + " não encontrado.");
                    }

                } else if (op == 4) {
                    // OPERAÇÃO: DELETE
                    System.out.print("Digite o ID do Aluno que deseja excluir: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    alunoDAO.excluir(id);

                } else if (op != 0) {
                    System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {
                System.err.println("Erro: Por favor, insira apenas números para IDs e opções.");
            } catch (Exception e) {
                System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }

    private static void menuAulas() {
        System.out.println("\n--- AULAS ---");
        System.out.println("1. Nova Aula | 2. Listar  |  0. Voltar");
        int op = Integer.parseInt(scanner.nextLine());
        if (op == 1) {
            System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Modalidade: "); String mod = scanner.nextLine();
            System.out.print("Horário (HH:mm): "); String hora = scanner.nextLine();
            System.out.print("Capacidade: "); int cap = Integer.parseInt(scanner.nextLine());
            aulaDAO.inserir(new Aula(id, mod, hora, cap));
        } else if (op == 2) {
            aulaDAO.listarTodos().forEach(a -> System.out.println(a.getModalidade() + " às " + a.getHorario()));
        }
    }

    private static void realizarInscricao() {
        System.out.println("\n--- NOVA MATRÍCULA ---");
        System.out.print("ID Aluno: "); int idAl = Integer.parseInt(scanner.nextLine());
        System.out.print("ID Aula: "); int idAu = Integer.parseInt(scanner.nextLine());

        Aluno al = alunoDAO.buscarPorId(idAl);
        Aula au = aulaDAO.buscarPorId(idAu);

        if (al != null && au != null) {
            System.out.print("ID Inscrição: "); int id = Integer.parseInt(scanner.nextLine());
            inscricaoDAO.inserir(new Inscricao(id, al, au, "08/05/2026"));
        } else {
            System.out.println("Aluno ou Aula não encontrados.");
        }
    }

    private static void menuInstrutores() {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- GESTÃO DE INSTRUTORES ---");
            System.out.println("1. Cadastrar | 2. Listar | 3. Buscar por ID | 4. Atualizar | 5. Excluir | 0. Voltar");
            System.out.print("Escolha: ");
            try {
                op = Integer.parseInt(scanner.nextLine());
                switch (op) {
                    case 1 -> {
                        System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nome: "); String nome = scanner.nextLine();
                        System.out.print("CPF (apenas números): "); String cpf = scanner.nextLine();
                        System.out.print("Especialidade: "); String esp = scanner.nextLine();
                        instrutorDAO.inserir(new Instrutor(id, nome, cpf, esp));
                    }
                    case 2 -> {
                        System.out.println("\nLista de Instrutores:");
                        instrutorDAO.listarTodos().forEach(System.out::println);
                    }
                    case 3 -> {
                        System.out.print("Digite o ID para busca: ");
                        int idBusca = Integer.parseInt(scanner.nextLine());
                        Instrutor i = instrutorDAO.buscarPorId(idBusca);
                        System.out.println(i != null ? i : "Instrutor não encontrado.");
                    }
                    case 4 -> {
                        System.out.print("ID do instrutor a editar: ");
                        int idEdit = Integer.parseInt(scanner.nextLine());
                        System.out.print("Novo Nome: "); String nNome = scanner.nextLine();
                        System.out.print("Novo CPF: "); String nCpf = scanner.nextLine();
                        System.out.print("Nova Especialidade: "); String nEsp = scanner.nextLine();
                        instrutorDAO.atualizar(new Instrutor(idEdit, nNome, nCpf, nEsp));
                    }
                    case 5 -> {
                        System.out.print("ID do instrutor a excluir: ");
                        int idEx = Integer.parseInt(scanner.nextLine());
                        instrutorDAO.excluir(idEx);
                    }
                }
            } catch (Exception e) {
                System.err.println("Entrada inválida.");
            }
        }
    }

    private static void menuFuncionarios() {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- GESTÃO DE FUNCIONÁRIOS ---");
            System.out.println("1. Cadastrar | 2. Listar | 0. Voltar");
            System.out.print("Escolha: ");
            try {
                op = Integer.parseInt(scanner.nextLine());
                switch (op) {
                    case 1 -> {
                        System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nome: "); String nome = scanner.nextLine();
                        System.out.print("CPF: "); String cpf = scanner.nextLine();
                        System.out.print("Departamento: "); String depto = scanner.nextLine();
                        funcionarioDAO.inserir(new Funcionario(id, nome, cpf, depto));
                    }
                    case 2 -> {
                        System.out.println("\nLista de Funcionários:");
                        funcionarioDAO.listarTodos().forEach(System.out::println);
                    }
                }
            } catch (Exception e) {
                System.err.println("Entrada inválida.");
            }
        }
    }
}