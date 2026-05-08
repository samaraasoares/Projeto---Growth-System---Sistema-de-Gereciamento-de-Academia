package model;

public class Aluno extends Pessoa {
    public Aluno(int id, String nome, String cpf) { super(id, nome, cpf); }
    @Override
    public String getTipo() { return "ALUNO"; }
}