package model;

public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String cpf;

    public Pessoa(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format("[%s] ID: %d | Nome: %s | CPF: %s", getTipo(), id, nome, cpf);
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
}