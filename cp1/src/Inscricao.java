<<<<<<< HEAD
public class Inscricao {
    private int id;
    private Aluno aluno;
    private Aula aula;
    private String dataInscricao;

    public Inscricao(int id, Aluno aluno, Aula aula, String dataInscricao) {
        setId(id);
        setAluno(aluno);
        setAula(aula);
        setDataInscricao(dataInscricao);
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID de inscrição inválido.");
        this.id = id;
    }

    public void setAluno(Aluno aluno) {
        if (aluno == null) throw new IllegalArgumentException("Aluno não pode ser nulo.");
        this.aluno = aluno;
    }

    public void setAula(Aula aula) {
        if (aula == null) throw new IllegalArgumentException("Aula não pode ser nula.");
        this.aula = aula;
    }

    public void setDataInscricao(String dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public int getId() { return id; }
    public Aluno getAluno() { return aluno; }
    public Aula getAula() { return aula; }

    @Override
    public String toString() {
        return "Inscrição [ID=" + id + ", Aluno=" + aluno.getNome() + ", Aula=" + aula.getModalidade() + "]";
    }
}
=======
public class Inscricao {
    private int id;
    private Aluno aluno;
    private Aula aula;
    private String dataInscricao;

    public Inscricao(int id, Aluno aluno, Aula aula, String dataInscricao) {
        setId(id);
        setAluno(aluno);
        setAula(aula);
        setDataInscricao(dataInscricao);
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID de inscrição inválido.");
        this.id = id;
    }

    public void setAluno(Aluno aluno) {
        if (aluno == null) throw new IllegalArgumentException("Aluno não pode ser nulo.");
        this.aluno = aluno;
    }

    public void setAula(Aula aula) {
        if (aula == null) throw new IllegalArgumentException("Aula não pode ser nula.");
        this.aula = aula;
    }

    public void setDataInscricao(String dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public int getId() { return id; }
    public Aluno getAluno() { return aluno; }
    public Aula getAula() { return aula; }

    @Override
    public String toString() {
        return "Inscrição [ID=" + id + ", Aluno=" + aluno.getNome() + ", Aula=" + aula.getModalidade() + "]";
    }
}
>>>>>>> 02e9cd8af30fc56ae23947483ebf0245215e4fc3
