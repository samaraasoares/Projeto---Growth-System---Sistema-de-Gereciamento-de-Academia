package model;

public class Instrutor extends Pessoa {
    private String especialidade;
    public Instrutor(int id, String nome, String cpf, String esp) {
        super(id, nome, cpf);
        this.especialidade = esp;
    }
    public String getEspecialidade() { return especialidade; }
    @Override
    public String getTipo() { return "INSTRUTOR"; }
}