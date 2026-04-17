import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private static ArrayList<Instrutor> listaInstrutores = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- FITTECH - ACADEMIA ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Cadastrar Instrutor");
            System.out.println("4. Listar Instrutores");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    for (Aluno a : listaAlunos) System.out.println(a);
                    break;
                case 3:
                    cadastrarInstrutor();
                    break;
                case 4:
                    for (Instrutor i : listaInstrutores) System.out.println(i);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarAluno() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF (11 dígitos): ");
            String cpf = scanner.nextLine();

            Aluno novo = new Aluno(id, nome, cpf);
            listaAlunos.add(novo);
            System.out.println("Aluno cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    private static void cadastrarInstrutor() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Especialidade: ");
            String esp = scanner.nextLine();

            Instrutor novo = new Instrutor(id, nome, esp);
            listaInstrutores.add(novo);
            System.out.println("Instrutor cadastrado!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
