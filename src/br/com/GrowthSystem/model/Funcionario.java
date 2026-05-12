package br.com.GrowthSystem.model;

public class Funcionario extends Pessoa {
    private String departamento;
    public Funcionario(int id, String nome, String cpf, String depto) {
        super(id, nome, cpf);
        this.departamento = depto;
    }
    public String getDepartamento() { return departamento; }
    @Override public String getTipo() { return "FUNCIONÁRIO"; }
}