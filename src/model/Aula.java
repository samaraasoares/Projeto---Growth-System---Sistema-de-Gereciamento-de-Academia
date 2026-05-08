package model;

public class Aula {
    private int id;
    private String modalidade;
    private String horario;
    private int capacidadeMax;

    public Aula(int id, String modalidade, String horario, int capacidadeMax) {
        this.id = id;
        this.modalidade = modalidade;
        this.horario = horario;
        this.capacidadeMax = capacidadeMax;
    }
    public int getId() { return id; }
    public String getModalidade() { return modalidade; }
    public String getHorario() { return horario; }
    public int getCapacidadeMax() { return capacidadeMax; }
}