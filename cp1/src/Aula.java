public class Aula {
    private int id;
    private String modalidade;
    private String horario; 
    private int capacidadeMax;

    public Aula(int id, String modalidade, String horario, int capacidadeMax) {
        setId(id);
        setModalidade(modalidade);
        setHorario(horario);
        setCapacidadeMax(capacidadeMax);
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID da aula inválido.");
        this.id = id;
    }

    public void setModalidade(String modalidade) {
        if (modalidade == null || modalidade.trim().isEmpty()) throw new IllegalArgumentException("A modalidade é obrigatória.");
        this.modalidade = modalidade;
    }

    public void setHorario(String horario) {
        if (horario == null || !horario.contains(":")) throw new IllegalArgumentException("Formato de horário inválido (Use HH:mm).");
        this.horario = horario;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        if (capacidadeMax <= 0) throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
        this.capacidadeMax = capacidadeMax;
    }

    public int getId() { return id; }
    public String getModalidade() { return modalidade; }
    public String getHorario() { return horario; }
    public int getCapacidadeMax() { return capacidadeMax; }

    @Override
    public String toString() {
        return String.format("Aula [ID=%d, Modalidade=%s, Horário=%s, Vagas=%d]", id, modalidade, horario, capacidadeMax);
    }
}
