import model.*;
import dao.*;
import util.ValidadorUtil;
import java.util.Scanner;
import java.util.List; // Importação necessária adicionada

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
                    case 1: menuAlunos(); break;
                    case 2: menuInstrutores(); break;
                    case 3: menuFuncionarios(); break;
                    case 4: menuAulas(); break;
                    case 5: realizarInscricao(); break;
                    case 0: System.out.println("Encerrando..."); break;
                    default: System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: Digite apenas números.");
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
                    System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome: "); String nome = scanner.nextLine();
                    System.out.print("CPF: "); String cpf = scanner.nextLine();
                    if (ValidadorUtil.isCpfValido(cpf)) {
                        alunoDAO.inserir(new Aluno(id, nome, cpf));
                    } else { System.out.println("❌ CPF Inválido."); }
                } else if (op == 2) {
                    alunoDAO.listarTodos().forEach(System.out::println);
                } else if (op == 3) {
                    System.out.print("ID do Aluno: "); int id = Integer.parseInt(scanner.nextLine());
                    if (alunoDAO.buscarPorId(id) != null) {
                        System.out.print("Novo Nome: "); String nome = scanner.nextLine();
                        System.out.print("Novo CPF: "); String cpf = scanner.nextLine();
                        alunoDAO.atualizar(new Aluno(id, nome, cpf));
                    } else { System.out.println("Aluno não encontrado."); }
                } else if (op == 4) {
                    System.out.print("ID para excluir: ");
                    alunoDAO.excluir(Integer.parseInt(scanner.nextLine()));
                }
            } catch (Exception e) { System.err.println("Erro: " + e.getMessage()); }
        }
    }

    private static void menuInstrutores() {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- GESTÃO DE INSTRUTORES ---");
            System.out.println("1. Cadastrar | 2. Listar | 3. Buscar ID | 4. Atualizar | 5. Excluir | 0. Voltar");
            System.out.print("Escolha: ");
            try {
                op = Integer.parseInt(scanner.nextLine());
                switch (op) {
                    case 1:
                        System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nome: "); String n = scanner.nextLine();
                        System.out.print("CPF: "); String c = scanner.nextLine();
                        System.out.print("Especialidade: "); String e = scanner.nextLine();
                        instrutorDAO.inserir(new Instrutor(id, n, c, e));
                        break;
                    case 2:
                        instrutorDAO.listarTodos().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID: ");
                        Instrutor ins = instrutorDAO.buscarPorId(Integer.parseInt(scanner.nextLine()));
                        System.out.println(ins != null ? ins : "Não encontrado.");
                        break;
                    case 4:
                        System.out.print("ID: "); int idU = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nome: "); String nu = scanner.nextLine();
                        System.out.print("CPF: "); String cu = scanner.nextLine();
                        System.out.print("Especialidade: "); String eu = scanner.nextLine();
                        instrutorDAO.atualizar(new Instrutor(idU, nu, cu, eu));
                        break;
                    case 5:
                        System.out.print("ID: ");
                        instrutorDAO.excluir(Integer.parseInt(scanner.nextLine()));
                        break;
                }
            } catch (Exception e) { System.err.println("Entrada inválida."); }
        }
    }

    private static void menuFuncionarios() {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- GESTÃO DE FUNCIONÁRIOS ---");
            System.out.println("1. Cadastrar | 2. Listar | 3. Atualizar | 4. Excluir | 0. Voltar");
            System.out.print("Escolha: ");
            try {
                op = Integer.parseInt(scanner.nextLine());
                switch (op) {
                    case 1:
                        System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nome: "); String nome = scanner.nextLine();
                        System.out.print("CPF: "); String cpf = scanner.nextLine();
                        System.out.print("Departamento: "); String depto = scanner.nextLine();
                        if (ValidadorUtil.isCpfValido(cpf)) {
                            funcionarioDAO.inserir(new Funcionario(id, nome, cpf, depto));
                        } else { System.out.println("❌ CPF Inválido."); }
                        break;
                    case 2:
                        funcionarioDAO.listarTodos().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID do Funcionário: ");
                        int idAtu = Integer.parseInt(scanner.nextLine());
                        if (funcionarioDAO.buscarPorId(idAtu) != null) {
                            System.out.print("Novo Nome: "); String nNome = scanner.nextLine();
                            System.out.print("Novo CPF: "); String nCpf = scanner.nextLine();
                            System.out.print("Novo Departamento: "); String nDepto = scanner.nextLine();
                            if (ValidadorUtil.isCpfValido(nCpf)) {
                                funcionarioDAO.atualizar(new Funcionario(idAtu, nNome, nCpf, nDepto));
                            } else { System.out.println("❌ Novo CPF Inválido."); }
                        } else { System.out.println("❌ Funcionário não encontrado."); }
                        break;
                    case 4:
                        System.out.print("ID para excluir: ");
                        funcionarioDAO.excluir(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 0: break;
                    default: System.out.println("Opção inválida.");
                }
            } catch (Exception e) { System.err.println("Erro: " + e.getMessage()); }
        }
    }

    private static void menuAulas() {
        System.out.println("\n--- AULAS ---");
        System.out.println("1. Nova Aula | 2. Listar | 0. Voltar");
        try {
            int op = Integer.parseInt(scanner.nextLine());
            if (op == 1) {
                System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Modalidade: "); String mod = scanner.nextLine();
                System.out.print("Horário (HH:mm): "); String h = scanner.nextLine();
                System.out.print("Capacidade: "); int c = Integer.parseInt(scanner.nextLine());
                aulaDAO.inserir(new Aula(id, mod, h, c));
            } else if (op == 2) {
                aulaDAO.listarTodos().forEach(a -> System.out.println(a.getModalidade() + " às " + a.getHorario()));
            }
        } catch (Exception e) { System.err.println("Erro."); }
    }

    private static void realizarInscricao() {
        try {
            System.out.println("\n--- NOVA MATRÍCULA ---");
            System.out.print("ID Aluno: "); int idAl = Integer.parseInt(scanner.nextLine());
            System.out.print("ID Aula: "); int idAu = Integer.parseInt(scanner.nextLine());
            Aluno al = alunoDAO.buscarPorId(idAl);
            Aula au = aulaDAO.buscarPorId(idAu);
            if (al != null && au != null) {
                System.out.print("ID Inscrição: "); int id = Integer.parseInt(scanner.nextLine());
                inscricaoDAO.inserir(new Inscricao(id, al, au, "08/05/2026"));
            } else { System.out.println("Aluno ou Aula não encontrados."); }
        } catch (Exception e) { System.err.println("Erro."); }
    }
}