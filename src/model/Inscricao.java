package model;

public class Inscricao {
    private int id;
    private Aluno aluno;
    private Aula aula;
    private String dataInscricao;

    public Inscricao(int id, Aluno aluno, Aula aula, String dataInscricao) {
        this.id = id;
        this.aluno = aluno;
        this.aula = aula;
        this.dataInscricao = dataInscricao;
    }
    public int getId() { return id; }
    public Aluno getAluno() { return aluno; }
    public Aula getAula() { return aula; }
    public String getDataInscricao() { return dataInscricao; }
}