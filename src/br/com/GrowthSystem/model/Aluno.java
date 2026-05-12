package br.com.GrowthSystem.model;
import br.com.GrowthSystem.util.Auditavel;
import br.com.GrowthSystem.util.Financeiro;

public class Aluno extends Pessoa implements Auditavel, Financeiro {
    private String log;
    public Aluno(int id, String nome, String cpf) { super(id, nome, cpf); }

    @Override public String getTipo() { return "ALUNO"; }
    @Override public void registrarLog(String acao) { this.log = acao; }
    @Override public String obterHistorico() { return this.log; }
    @Override public double calcularValor() { return 150.00; }
}