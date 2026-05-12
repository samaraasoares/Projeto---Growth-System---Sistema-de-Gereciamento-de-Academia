package br.com.GrowthSystem.model;
import br.com.GrowthSystem.util.Auditavel;
import br.com.GrowthSystem.util.Financeiro;

public class Instrutor extends Pessoa implements Auditavel, Financeiro {
    private String especialidade;
    private String log;

    public Instrutor(int id, String nome, String cpf, String esp) {
        super(id, nome, cpf);
        this.especialidade = esp;
    }

    public String getEspecialidade() { return especialidade; }
    @Override public String getTipo() { return "INSTRUTOR"; }
    @Override public void registrarLog(String acao) { this.log = acao; }
    @Override public String obterHistorico() { return this.log; }
    @Override public double calcularValor() { return 2500.00; }
}