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
        System.out.println("\n--- ALUNOS ---");
        System.out.println("1. Cadastrar | 2. Listar | 3. Atualizar | 4. Excluir");
        int op = Integer.parseInt(scanner.nextLine());
        if (op == 1) {
            System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nome: "); String nome = scanner.nextLine();
            System.out.print("CPF: "); String cpf = scanner.nextLine();

            if (ValidadorUtil.isCpfValido(cpf)) {
                alunoDAO.inserir(new Aluno(id, nome, cpf));
            } else {
                System.out.println("❌ CPF Inválido.");
            }
        } else if (op == 2) {
            alunoDAO.listarTodos().forEach(System.out::println);
        }
        // ... (Implementar case 3 e 4 chamando alunoDAO.atualizar e alunoDAO.excluir)
    }

    private static void menuAulas() {
        System.out.println("\n--- AULAS ---");
        System.out.println("1. Nova Aula | 2. Listar");
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
            System.out.println("❌ Aluno ou Aula não encontrados.");
        }
    }

    private static void menuInstrutores() { /* Lógica similar ao menuAlunos usando instrutorDAO */ }
    private static void menuFuncionarios() { /* Lógica similar ao menuAlunos usando funcionarioDAO */ }
}