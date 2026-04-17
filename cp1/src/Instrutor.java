public class Instrutor {
    private int id;
    private String nome;
    private String especialidade;

    public Instrutor(int id, String nome, String especialidade) {
        setId(id);
        setNome(nome);
        setEspecialidade(especialidade);
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID do instrutor deve ser positivo.");
        this.id = id;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio.");
        this.nome = nome;
    }

    public void setEspecialidade(String especialidade) {
        if (especialidade == null || especialidade.trim().isEmpty()) throw new IllegalArgumentException("Especialidade não pode ser vazia.");
        this.especialidade = especialidade;
    }


    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecialidade() { return especialidade; }

    @Override
    public String toString() {
        return String.format("Instrutor [ID=%d, Nome=%s, Especialidade=%s]", id, nome, especialidade);
    }
}